package au.com.treeshake.linkchecker.service;

import java.util.concurrent.CompletableFuture;

@FunctionalInterface
public interface HttpRequestAsyncService<T> {

    CompletableFuture<T> performGetRequest(String url);
}
