package au.com.treeshake.linkchecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.http.HttpStatusCode;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class LinkCheckerService {

    private static final Logger LOG = LoggerFactory.getLogger(LinkCheckerService.class);
    
    Elements extractLinks(File file) throws IOException {
        LOG.info("Extracting links from file: {}", file.getName());
        Document doc = Jsoup.parse(file);
        return doc.select("a[href]");
    }

    @Async
    CompletableFuture<Link> fetchUrlAsync(String url) throws InterruptedException {
        Link link = new Link(url);
        LOG.info("Started task: {}", link);
        RestClient defaultClient = RestClient.create();
        var response = defaultClient.get().uri(url).retrieve()
                // Handle any HTTP status code that is an error (4xx, 5xx)
                .onStatus(HttpStatusCode::isError, (_, res) -> link.setStatus(res.getStatusCode()))
                .toBodilessEntity();
        link.setStatus(response.getStatusCode());
        LOG.info("Finished task: {}", link);
        return CompletableFuture.completedFuture(link);
    }
}
