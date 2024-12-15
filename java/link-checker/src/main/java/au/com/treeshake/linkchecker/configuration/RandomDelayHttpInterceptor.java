package au.com.treeshake.linkchecker.configuration;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

@Component
public class RandomDelayHttpInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(RandomDelayHttpInterceptor.class);
    private static final int MAX_DELAY = 5000;
    private final Random random = new Random();
    
    @SneakyThrows(InterruptedException.class)
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        int delay = random.nextInt(MAX_DELAY); // Random delay between 0 and 5000 milliseconds
        LOG.info("Adding random delay of {} milliseconds", delay);
        Thread.sleep(delay);
        return execution.execute(request, body);
    }
}
