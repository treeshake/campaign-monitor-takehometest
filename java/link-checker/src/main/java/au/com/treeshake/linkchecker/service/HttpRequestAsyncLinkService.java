package au.com.treeshake.linkchecker.service;

import au.com.treeshake.linkchecker.domain.DurationTimer;
import au.com.treeshake.linkchecker.domain.Link;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class HttpRequestAsyncLinkService implements HttpRequestAsyncService<Link> {

    private HttpRequestService<Link> httpRequestService;
    
    public HttpRequestAsyncLinkService(HttpRequestService<Link> httpRequestService) {
        this.httpRequestService = httpRequestService;
    }

    @Async
    @Override
    public CompletableFuture<Link> performGetRequest(String url) {
        if (url == null) {
            throw new IllegalArgumentException("URL cannot be null");
        }
        log.info("Started task: {}", url);
        var timer = new DurationTimer();
        timer.start();
        var link = httpRequestService.performGetRequest(url);
        timer.stop();
        log.info("Finished task: {}. Took: {}ms", link, timer.getDurationInMillis());
        return CompletableFuture.completedFuture(link);
    }
}
