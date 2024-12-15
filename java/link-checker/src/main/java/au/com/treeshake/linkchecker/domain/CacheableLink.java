package au.com.treeshake.linkchecker.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class CacheableLink extends Link implements Serializable {

    private static final long serialVersionUID = 1L;
    private CacheStatus cacheStatus;

    public CacheableLink(String url, DurationTimer timer) {
        super(url, timer);
        this.cacheStatus = CacheStatus.MISS;
    }
}
