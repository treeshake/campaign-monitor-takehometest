package au.com.treeshake.linkchecker.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class JsoupLinkExtractionService implements LinkExtractionService<Elements> {

    private static final Logger LOG = LoggerFactory.getLogger(JsoupLinkExtractionService.class);

    @Override
    public Elements extractLinks(Resource resource) throws IOException {
        if (resource == null) {
            throw new IllegalArgumentException("Resource cannot be null");
        }
        var file = resource.getFile();
        LOG.info("Extracting links from file: {}", file.getName());
        Document doc = Jsoup.parse(file);
        return doc.select("a[href]");
    }
}
