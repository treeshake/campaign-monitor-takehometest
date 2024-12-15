package au.com.treeshake.linkchecker.configuration;

import au.com.treeshake.linkchecker.component.RandomDelayHttpInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Configuration
@EnableAsync
@EnableCaching
public class AppConfiguration {

    private static final Logger log = LoggerFactory.getLogger(AppConfiguration.class);

    @Bean
    public RestClient restClient(RandomDelayHttpInterceptor randomDelayHttpInterceptor) {
        return RestClient.builder().requestInterceptor(randomDelayHttpInterceptor).build();
    }

    @Bean
    public Cache linksCache(Resource cacheResource) {
        var store = readCache(cacheResource);
        if (store != null) {
            return new ConcurrentMapCache("links", store, true);
        }
        return new ConcurrentMapCache("links");
    }

    @SuppressWarnings("unchecked")
    private ConcurrentMap<Object, Object> readCache(Resource cacheResource) {
        try (var fileInputStream = new FileInputStream(cacheResource.getFile());
             var objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ConcurrentMap<Object, Object>) objectInputStream.readObject();
        } catch (Exception e) {
            // Ignore, cache file does not exist or is corrupted - A new one will be created.
            return null;
        }
    }

    @Bean
    public Resource cacheResource(ResourceLoader resourceLoader) throws IOException {
        var resource = resourceLoader.getResource("file:cache/links.cache");
        if (!resource.exists()) {
            resource.getFile().createNewFile();
            log.info("Created cache file: {}", resource.getFile().getAbsolutePath());
        }
        return resource;
    }

    @Bean
    public SimpleCacheManager linksCacheManager(Cache linksCache) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(linksCache));
        return cacheManager;
    }

}
