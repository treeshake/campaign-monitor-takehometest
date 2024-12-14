package au.com.treeshake.linkchecker.domain;

public class CachableLink extends Link {
    
    private boolean cacheHit;
    

    public CachableLink(String url) {
        super(url);
    }

    public boolean isCacheHit() {
        return cacheHit;
    }

    public void setCacheHit(boolean cacheHit) {
        this.cacheHit = cacheHit;
    }
    
}
