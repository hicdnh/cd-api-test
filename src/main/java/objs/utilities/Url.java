package objs.utilities;

/**
 * @author chen
 */
public class Url {
    private String url;
    private String domain;

    public Url(String url, String domain) throws Exception {
        this.domain = domain;
        this.url = String.format("{}{}", domain, url);
    }

    public Url(String url) throws Exception {
        this.url = url;
    }

    public boolean isNeedExec(){
        return this.url.isEmpty()?false: true;
    }
    @Override
    public String toString() {
        return this.url;
    }
}
