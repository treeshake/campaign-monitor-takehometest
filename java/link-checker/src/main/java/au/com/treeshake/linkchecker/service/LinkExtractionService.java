package au.com.treeshake.linkchecker.service;

import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Interface for extracting links from a resource.
 *
 * @param <T> A generic type that represents the extracted links.
 */
public interface LinkExtractionService<T> {

    /**
     * Extracts links from the given resource.
     *
     * @param resource The resource to extract links from (file, url or otherwise).
     * @return T - The type that represents the extracted links.
     * @throws IOException If the resource cannot be read.
     */
    T extractLinks(Resource resource) throws IOException;
}
