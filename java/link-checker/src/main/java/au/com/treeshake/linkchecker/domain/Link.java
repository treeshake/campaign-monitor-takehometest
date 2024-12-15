package au.com.treeshake.linkchecker.domain;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.io.Serializable;

@Data
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String url;
    private HttpStatusCode status;
}
