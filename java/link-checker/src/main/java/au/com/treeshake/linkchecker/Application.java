package au.com.treeshake.linkchecker;

import au.com.treeshake.linkchecker.domain.Link;
import au.com.treeshake.linkchecker.service.AsyncFetchUrlService;
import au.com.treeshake.linkchecker.service.LinkExtractionService;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ResourceLoader;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

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

    private final AsyncFetchUrlService restClientService;
    private final LinkExtractionService<Elements> linkExtractionService;
    private final ResourceLoader resourceLoader;

    public Application(AsyncFetchUrlService restClientService,
                       LinkExtractionService<Elements> linkExtractionService,
                       ResourceLoader resourceLoader) {
        this.restClientService = restClientService;
        this.linkExtractionService = linkExtractionService;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var resource = resourceLoader.getResource("classpath:page.html");
        var links = linkExtractionService.extractLinks(resource);
        var requests = new ArrayList<CompletableFuture<Link>>();
        for (Element link : links) {
            var url = link.attr("abs:href");
            requests.add(restClientService.fetchUrl(url));
        }
        requests.stream().forEach(CompletableFuture::join);
    }
}