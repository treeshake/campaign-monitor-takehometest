package au.com.treeshake.linkchecker.service;

@FunctionalInterface
public interface HttpRequestService<T> {

    T performGetRequest(String url);
}
