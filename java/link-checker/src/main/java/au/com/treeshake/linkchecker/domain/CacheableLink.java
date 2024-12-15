package au.com.treeshake.linkchecker.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class CacheableLink extends Link implements Serializable {

    private static final long serialVersionUID = 1L;
    private CacheStatus cacheStatus;

    public CacheableLink(String url) {
        super(url, new DurationTimer());
        this.cacheStatus = CacheStatus.MISS;
    }
}
