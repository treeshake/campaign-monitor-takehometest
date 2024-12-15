package au.com.treeshake.linkchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Using Spring, since it gives some suitable defaults around async processing,
 * specifically, @EnableAsync and @Async annotations.
 * <p>
 * When starting the application, 20 threads are created, each thread has a http request from
 * page.html. Results are returned async as demonstrated by the logging output to console which
 * logs the thread ID. e.g. [SimpleAsyncTaskExecutor-18]
 * <p>
 * Special note: Fetch request to amazon.com returns 503 as it has detected that this program
 * is crawling their website.
 */
@ComponentScan
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}