package au.com.treeshake.linkchecker;

import org.springframework.http.HttpStatusCode;

public class Link {
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
