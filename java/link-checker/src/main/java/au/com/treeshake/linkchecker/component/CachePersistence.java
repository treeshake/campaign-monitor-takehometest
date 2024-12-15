package au.com.treeshake.linkchecker.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


/**
 * Persists the cached data to disk, so it can be primed before and saved after each run,
 */
@Slf4j
@Component
public class CachePersistence implements DisposableBean {

    private final Resource cacheResource;
    private final SimpleCacheManager cacheManager;

    public CachePersistence(Resource cacheResource, SimpleCacheManager cacheManager) {
        this.cacheResource = cacheResource;
        this.cacheManager = cacheManager;
    }

    @Override
    public void destroy() throws Exception {
        log.info("Persisting cache to disk...");
        var fileOutputStream = new FileOutputStream(cacheResource.getFile());
        var objectOutputStream = new ObjectOutputStream(fileOutputStream);
        var cache = cacheManager.getCache("links").getNativeCache();
        objectOutputStream.writeObject(cache);
        objectOutputStream.flush();
        objectOutputStream.close();
        log.info("Persisting cache to disk complete.");
    }
}
