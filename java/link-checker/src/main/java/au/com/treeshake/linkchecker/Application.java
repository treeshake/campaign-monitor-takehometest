package au.com.treeshake.linkchecker;

import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * Using Spring, since it gives some suitable defaults around async processing.
 * 
 * Special note: Fetch request to amazon.com returns 503 as it has detected that this program
 * is crawling their website.
 */
@ComponentScan
@Configuration
@EnableAsync
public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        LinkCheckerService service = ctx.getBean(LinkCheckerService.class);

        File file = ResourceUtils.getFile("classpath:page.html");
        var links = service.extractLinks(file);

        var requests = new ArrayList<CompletableFuture<Link>>();
        for (Element link : links) {
            var url = link.attr("abs:href");
            requests.add(service.fetchUrlAsync(url));
        }
        requests.stream().forEach(CompletableFuture::join);
    }

}