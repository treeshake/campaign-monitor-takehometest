package au.com.treeshake.linkchecker.service;

public interface HttpRequestService<T> {

    T performGetRequest(String url);
}
