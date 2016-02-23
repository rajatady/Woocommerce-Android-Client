package com.aadira.library.Models;

public class Product_attribute extends WCObject {

    private long id;
    private String name;
    private String slug;
    private String type;
    private String orderBy;
    private boolean hasArchives;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isHasArchives() {
        return hasArchives;
    }

    public void setHasArchives(boolean hasArchives) {
        this.hasArchives = hasArchives;
    }
}
 