package au.com.treeshake.linkchecker.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatusCode;

import java.io.Serializable;

@ToString(exclude = {"timer"})
@Data
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String url;
    private final DurationTimer timer;
    private HttpStatusCode status;
}
