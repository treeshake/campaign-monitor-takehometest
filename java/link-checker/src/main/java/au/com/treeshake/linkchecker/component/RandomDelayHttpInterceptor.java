package au.com.treeshake.linkchecker.component;

import lombok.SneakyThrows;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

@Component
public class RandomDelayHttpInterceptor implements ClientHttpRequestInterceptor {

    private static final int MAX_DELAY = 20000;
    private final Random random = new Random();

    @SneakyThrows(InterruptedException.class)
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        int delay = random.nextInt(MAX_DELAY);
        Thread.sleep(delay);
        return execution.execute(request, body);
    }
}
