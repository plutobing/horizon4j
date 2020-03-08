package com.gome.cloud.horizon4j;

/**
 * Created by pluto on 1/10/16.
 */
public class Panel extends Horizon4jComponent {

    protected Dashboard registered;

    protected String indexUrlPath;

    public Panel(String name, String slug, String indexUrlPath, Dashboard registered) {
        super(name, slug);
        this.indexUrlPath = indexUrlPath == null || "".equals(indexUrlPath) ? "index" : indexUrlPath;
    }

    @Override
    public String getAbstractUrlPath() {
        StringBuffer buffer = new StringBuffer(this.registered.getSlug());
        buffer.append("/").append(this.slug).append("/").append(this.getIndexUrlPath());
        return buffer.toString();
    }

    @Override
    public String getAttrString() {
        return null;
    }

    public String getIndexUrlPath() {
        return indexUrlPath;
    }

    public void setIndexUrlPath(String indexUrlPath) {
        this.indexUrlPath = indexUrlPath == null || "".equals(indexUrlPath) ? "index" : indexUrlPath;
    }

    public void setRegistered(Dashboard dashboard) {
        this.registered = dashboard;
    }

    public Dashboard getRegistered() {
        return this.registered;
    }
}
