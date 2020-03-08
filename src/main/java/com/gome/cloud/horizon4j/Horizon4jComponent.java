package com.gome.cloud.horizon4j;

/**
 * Created by pluto on 1/10/16.
 */
public abstract class Horizon4jComponent implements Namable {
    /**
     * The display name of current dashboard
     */
    protected String name;
    /**
     * The short name such as id of current dashboard
     */
    protected String slug;
    /**
     * The icon name of current dashboard
     */
    protected String icon;

    public Horizon4jComponent(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public abstract String getAbstractUrlPath();

    public abstract String getAttrString();

}
