package au.com.treeshake.linkchecker.service;

import au.com.treeshake.linkchecker.domain.Link;

import java.net.URL;
import java.util.concurrent.CompletableFuture;

/**
 * Interface for fetching links asynchronously.
 */
@FunctionalInterface
public interface AsyncFetchUrlService {

    /**
     * Fetches the URL asynchronously.
     *
     * @param url The URL to fetch.
     * @return A CompletableFuture that will contain the fetched link.
     */
    CompletableFuture<Link> fetchUrl(URL url);
}
