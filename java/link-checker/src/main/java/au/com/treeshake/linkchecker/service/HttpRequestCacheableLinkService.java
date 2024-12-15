package au.com.treeshake.linkchecker.service;

import au.com.treeshake.linkchecker.domain.Link;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@CacheConfig(cacheNames = "links", cacheManager = "linksCacheManager")
@Service
public class HttpRequestCacheableLinkService implements HttpRequestService<Link> {

    private final RestClient restClient;

    public HttpRequestCacheableLinkService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Cacheable
    @Override
    public Link performGetRequest(String url) {
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
