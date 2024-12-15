package au.com.treeshake.linkchecker.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestClient;

@Configuration
@EnableAsync
//@EnableCaching
public class AppConfiguration {

    @Bean
    public RestClient restClient(RandomDelayHttpInterceptor randomDelayHttpInterceptor) {
        return RestClient.builder().requestInterceptor(randomDelayHttpInterceptor).build();
    }
}
