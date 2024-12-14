package au.com.treeshake.linkchecker.domain;

import org.springframework.http.HttpStatusCode;

import java.io.Serializable;

public class Link implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String url;
    private HttpStatusCode status;

    public Link(String url) {
        this.url = url;
    }

    public HttpStatusCode getStatus() {
        return status;
    }

    public void setStatus(HttpStatusCode status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", status=" + status +
                '}';
    }
}
