package au.com.treeshake.linkchecker.configuration;

import au.com.treeshake.linkchecker.component.RandomDelayHttpInterceptor;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestClient;

import java.util.List;

@Configuration
@EnableAsync
@EnableCaching
public class AppConfiguration {

    @Bean
    public RestClient restClient(RandomDelayHttpInterceptor randomDelayHttpInterceptor) {
        return RestClient.builder().requestInterceptor(randomDelayHttpInterceptor).build();
    }
    
    @Bean
    public Cache linksCache() {
        return new ConcurrentMapCache("links");
    }

    @Bean
    public SimpleCacheManager linksCacheManager(Cache linksCache) {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(List.of(linksCache));
        return cacheManager;
    }

}
