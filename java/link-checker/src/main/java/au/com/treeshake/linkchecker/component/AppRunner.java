package au.com.treeshake.linkchecker.component;

import au.com.treeshake.linkchecker.domain.Link;
import au.com.treeshake.linkchecker.service.HttpRequestAsyncService;
import au.com.treeshake.linkchecker.service.HttpRequestService;
import au.com.treeshake.linkchecker.service.UrlExtractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppRunner implements ApplicationRunner {

    private final HttpRequestAsyncService<Link> asyncService;
    private final HttpRequestService<Link> linkService;
    private final UrlExtractionService urlExtractionService;
    private final ResourceLoader resourceLoader;

    public AppRunner(HttpRequestAsyncService<Link> asyncService,
                     HttpRequestService<Link> linkService,
                     UrlExtractionService urlExtractionService,
                     ResourceLoader resourceLoader) {
        this.asyncService = asyncService;
        this.linkService = linkService;
        this.urlExtractionService = urlExtractionService;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var resource = resourceLoader.getResource("classpath:page.html");
        var urls = urlExtractionService.extractLinks(resource);

        if (urls.isEmpty()) {
            log.info("No URLs found in the page. Finishing...");
            return;
        }

        Link link = linkService.performGetRequest("https://www.google.com");
        log.info("Link: {}. Duration: {}ms", link, link.getTimer().getDurationInMillis());
        Link link2 = linkService.performGetRequest("https://www.google.com");
        log.info("Link: {}. Duration: {}ms", link2, link2.getTimer().getDurationInMillis());
//        var futures = urls.stream()
//                .map(URL::toString)
//                .map(asyncService::performGetRequest)
//                .collect(Collectors.toList());
//
//        futures.stream().map(CompletableFuture::join);
    }
}
