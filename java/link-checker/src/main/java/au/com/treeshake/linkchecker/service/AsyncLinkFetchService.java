package au.com.treeshake.linkchecker.service;

import au.com.treeshake.linkchecker.domain.Link;

import java.util.concurrent.CompletableFuture;

/**
 * Interface for fetching links asynchronously.
 */
public interface AsyncLinkFetchService {

    /**
     * Fetches the URL asynchronously.
     *
     * @param url The URL to fetch.
     * @return A CompletableFuture that will contain the fetched link.
     */
    CompletableFuture<Link> fetchUrl(String url);
}
