package au.com.treeshake.linkchecker;

import au.com.treeshake.linkchecker.domain.Link;
import au.com.treeshake.linkchecker.service.JsoupLinkExtractionService;
import au.com.treeshake.linkchecker.service.RestClientLinkFetchService;
import org.jsoup.nodes.Element;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableAsync;

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
@Configuration
@EnableAsync
public class Application implements ApplicationRunner {

    private final RestClientLinkFetchService service;
    private final JsoupLinkExtractionService linkExtractionService;
    private final ResourceLoader resourceLoader;

    public Application(RestClientLinkFetchService service,
                       JsoupLinkExtractionService linkExtractionService,
                       ResourceLoader resourceLoader) {
        this.service = service;
        this.linkExtractionService = linkExtractionService;
        this.resourceLoader = resourceLoader;
    }

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        var app = ctx.getBean(Application.class);
        app.run(new DefaultApplicationArguments(args));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var resource = resourceLoader.getResource("classpath:page.html");
        var links = linkExtractionService.extractLinks(resource);
        var requests = new ArrayList<CompletableFuture<Link>>();
        for (Element link : links) {
            var url = link.attr("abs:href");
            requests.add(service.fetchUrl(url));
        }
        requests.stream().forEach(CompletableFuture::join);
    }
}