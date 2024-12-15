package au.com.treeshake.linkchecker.service;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

/**
 * Interface for extracting links from a resource.
 */
public interface UrlExtractionService {

    /**
     * Extracts links from the given resource.
     *
     * @param resource The resource to extract links from (file, url or otherwise).
     * @throws IOException If the resource cannot be read.
     */
    HashSet<URL> extractLinks(Resource resource) throws IOException;
}
