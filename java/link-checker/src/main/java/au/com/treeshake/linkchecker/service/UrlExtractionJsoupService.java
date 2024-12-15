package au.com.treeshake.linkchecker.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Slf4j
@Service
public class UrlExtractionJsoupService implements UrlExtractionService {

    @Override
    public List<URL> extractLinks(Resource resource) throws IOException {
        if (resource == null) {
            throw new IllegalArgumentException("Resource cannot be null");
        }
        var file = resource.getFile();
        log.info("Extracting links from file: {}", file.getName());
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
