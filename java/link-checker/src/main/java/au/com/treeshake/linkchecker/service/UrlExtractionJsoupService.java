package au.com.treeshake.linkchecker.service;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class UrlExtractionJsoupService implements UrlExtractionService {

    private static final Logger LOG = LoggerFactory.getLogger(UrlExtractionJsoupService.class);

    @Override
    public List<URL> extractLinks(Resource resource) throws IOException {
        if (resource == null) {
            throw new IllegalArgumentException("Resource cannot be null");
        }
        var file = resource.getFile();
        LOG.info("Extracting links from file: {}", file.getName());
        var doc = Jsoup.parse(file);
        var hrefElements = doc.select("a[href]");
        return hrefElements.stream()
                .map(element -> element.attr("abs:href"))
                .map(this::mapToUrl)
                .toList();
    }

    @SneakyThrows(MalformedURLException.class)
    private URL mapToUrl(String element) {
        return new URL(element);
    }
}
