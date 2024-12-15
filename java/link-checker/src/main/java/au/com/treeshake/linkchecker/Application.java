package au.com.treeshake.linkchecker;

import au.com.treeshake.linkchecker.domain.Link;
import au.com.treeshake.linkchecker.service.HttpRequestAsyncService;
import au.com.treeshake.linkchecker.service.UrlExtractionService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ResourceLoader;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Using Spring, since it gives some suitable defaults around async processing,
 * specifically, @EnableAsync and @Async annotations.
 * <p>
 * When starting the application, 20 threads are created, each thread has a http request from
 * page.html. Results are returned async as demonstrated by the logging output to console which
 * logs the thread ID. e.g. [SimpleAsyncTaskExecutor-18]
 * <p>
 * Special note: Fetch request to amazon.com returns 503 as it has detected that this program
 * is crawling their website.
 */
@ComponentScan
public class Application implements ApplicationRunner {

    /**
     * Main entry point for the application.
     *
     * @param args No args required.
     * @throws Exception - Propagate any exceptions out of the application.
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    private final HttpRequestAsyncService<Link> asyncService;
    private final UrlExtractionService urlExtractionService;
    private final ResourceLoader resourceLoader;

    public Application(HttpRequestAsyncService<Link> asyncService,
                       UrlExtractionService urlExtractionService,
                       ResourceLoader resourceLoader) {
        this.asyncService = asyncService;
        this.urlExtractionService = urlExtractionService;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var resource = resourceLoader.getResource("classpath:page.html");
        var urls = urlExtractionService.extractLinks(resource);

        var futures = urls.stream()
                .map(asyncService::performGetRequest)
                .collect(Collectors.toList());

        futures.stream().map(CompletableFuture::join);
    }
}