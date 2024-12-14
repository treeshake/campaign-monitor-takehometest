package au.com.treeshake.linkchecker.service;

import au.com.treeshake.linkchecker.domain.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.concurrent.CompletableFuture;

@Service
public class RestClientLinkFetchService implements AsyncLinkFetchService{

    private static final Logger LOG = LoggerFactory.getLogger(RestClientLinkFetchService.class);
    
    @Async
    public CompletableFuture<Link> fetchUrl(String url) {
        Link link = new Link(url);
        LOG.info("Started task: {}", link);
        RestClient defaultClient = RestClient.create();
        var response = defaultClient.get().uri(url).retrieve()
                // Handle any HTTP status code that is an error (4xx, 5xx), otherwise without this line,
                // exception is thrown by the http client as a default.
                .onStatus(HttpStatusCode::isError, (req, res) -> link.setStatus(res.getStatusCode()))
                // Discard the response body, only interested in the HTTP status.
                .toBodilessEntity();
        link.setStatus(response.getStatusCode());
        LOG.info("Finished task: {}", link);
        return CompletableFuture.completedFuture(link);
    }
}
