package au.com.treeshake.linkchecker.service;

import au.com.treeshake.linkchecker.domain.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URL;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncFetchUrlRestClientService implements AsyncFetchUrlService {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncFetchUrlRestClientService.class);

    @Async
    public CompletableFuture<Link> fetchUrl(URL url) {
        LOG.info("Started task: {}", url.toString());
        var defaultClient = RestClient.create();
        var link = performHttpRequest(defaultClient, url.toString());
        LOG.info("Finished task: {}", link);
        return CompletableFuture.completedFuture(link);
    }

    @Cacheable("links")
    private Link performHttpRequest(RestClient restClient, String url) {
        var link = new Link(url);
        var response = restClient.get().uri(url).retrieve()
                // Handle any HTTP status code that is an error (4xx, 5xx), otherwise without this line,
                // exception is thrown by the http client as a default.
                .onStatus(HttpStatusCode::isError, (req, res) -> link.setStatus(res.getStatusCode()))
                // Discard the response body, only interested in the HTTP status.
                .toBodilessEntity();
        link.setStatus(response.getStatusCode());
        return link;
    }
}
