package com.aadira.library.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

public class Product extends WCObject implements Parcelable {


    public Product() {
    }

    protected String title;
    protected long id;
    protected Date created_at;
    protected Date updated_at;
    protected String type;
    protected String permalink;
    protected String sku;
    protected String price;
    protected String regular_price;
    protected String sale_price;
    protected boolean managing_stock;
    protected int stock_quantity;
    protected boolean in_stock;
    protected boolean backorders_allowed;
    protected boolean backordered;
    protected boolean sold_individually;
    protected boolean featured;
    protected boolean visible;
    protected String catalog_visibility;
    protected boolean on_sale;
    protected String product_url;
    protected String button_text;
    protected String weight;
    protected boolean shipping_required;
    protected boolean  shipping_taxable;
    protected String shipping_class;
    protected String shipping_class_id;
    protected String long_description;
    protected String short_description;
    protected boolean reviews_allowed;
    protected String average_rating;
    protected int rating_count;
    protected ArrayList<Long> related_ids;
    protected ArrayList<Long> upsell_ids;
    protected ArrayList<Long> cross_sell_ids;
    protected long parent_id;
    protected ArrayList<String> categories;
    protected ArrayList<String> tags;
    protected ArrayList<ProductImage> productImages;
    protected String featured_image_url;
    protected int total_sales;
    protected boolean hasVariations;
    protected ArrayList<String> variationId;
    protected ArrayList<ProductAttribute> productAttributeArrayList;


    public boolean hasVariations() {
        return hasVariations;
    }

    public ArrayList<String> getVariationId() {
        return variationId;
    }




    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getType() {
        return type;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getSku() {
        return sku;
    }

    public String getPrice() {
        return price;
    }

    public String getRegular_price() {
        return regular_price;
    }

    public String getSale_price() {
        return sale_price;
    }

    public boolean isManaging_stock() {
        return managing_stock;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public boolean isIn_stock() {
        return in_stock;
    }

    public boolean isBackorders_allowed() {
        return backorders_allowed;
    }

    public boolean isBackordered() {
        return backordered;
    }

    public boolean isSold_individually() {
        return sold_individually;
    }

    public boolean isFeatured() {
        return featured;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getCatalog_visibility() {
        return catalog_visibility;
    }

    public boolean isOn_sale() {
        return on_sale;
    }

    public String getProduct_url() {
        return product_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public String getWeight() {
        return weight;
    }

    public boolean isShipping_required() {
        return shipping_required;
    }

    public boolean isShipping_taxable() {
        return shipping_taxable;
    }

    public String getShipping_class() {
        return shipping_class;
    }

    public String getShipping_class_id() {
        return shipping_class_id;
    }

    public String getLong_description() {
        return long_description;
    }

    public String getShort_description() {
        return short_description;
    }

    public boolean isReviews_allowed() {
        return reviews_allowed;
    }

    public String getAverage_rating() {
        return average_rating;
    }

    public int getRating_count() {
        return rating_count;
    }

    public ArrayList<Long> getRelated_ids() {
        return related_ids;
    }

    public ArrayList<Long> getUpsell_ids() {
        return upsell_ids;
    }

    public ArrayList<Long> getCross_sell_ids() {
        return cross_sell_ids;
    }

    public long getParent_id() {
        return parent_id;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public ArrayList<ProductImage> getProductImages() {
        return productImages;
    }

    public String getFeatured_image_url() {
        return featured_image_url;
    }

    public int getTotal_sales() {
        return total_sales;
    }


    public ArrayList<ProductAttribute> getProductAttributeArrayList() {
        return productAttributeArrayList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRegular_price(String regular_price) {
        this.regular_price = regular_price;
    }

    public void setSale_price(String sale_price) {
        this.sale_price = sale_price;
    }

    public void setManaging_stock(boolean managing_stock) {
        this.managing_stock = managing_stock;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public void setIn_stock(boolean in_stock) {
        this.in_stock = in_stock;
    }

    public void setBackorders_allowed(boolean backorders_allowed) {
        this.backorders_allowed = backorders_allowed;
    }

    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    public void setSold_individually(boolean sold_individually) {
        this.sold_individually = sold_individually;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setCatalog_visibility(String catalog_visibility) {
        this.catalog_visibility = catalog_visibility;
    }

    public void setOn_sale(boolean on_sale) {
        this.on_sale = on_sale;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setShipping_required(boolean shipping_required) {
        this.shipping_required = shipping_required;
    }

    public void setShipping_taxable(boolean shipping_taxable) {
        this.shipping_taxable = shipping_taxable;
    }

    public void setShipping_class(String shipping_class) {
        this.shipping_class = shipping_class;
    }

    public void setShipping_class_id(String shipping_class_id) {
        this.shipping_class_id = shipping_class_id;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public void setReviews_allowed(boolean reviews_allowed) {
        this.reviews_allowed = reviews_allowed;
    }

    public void setAverage_rating(String average_rating) {
        this.average_rating = average_rating;
    }

    public void setRating_count(int rating_count) {
        this.rating_count = rating_count;
    }

    public void setRelated_ids(ArrayList<Long> related_ids) {
        this.related_ids = related_ids;
    }

    public void setUpsell_ids(ArrayList<Long> upsell_ids) {
        this.upsell_ids = upsell_ids;
    }

    public void setCross_sell_ids(ArrayList<Long> cross_sell_ids) {
        this.cross_sell_ids = cross_sell_ids;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setProductImages(ArrayList<ProductImage> productImages) {
        this.productImages = productImages;
    }

    public void setFeatured_image_url(String featured_image_url) {
        this.featured_image_url = featured_image_url;
    }

    public void setTotal_sales(int total_sales) {
        this.total_sales = total_sales;
    }

    public void setHasVariations(boolean hasVariations) {
        this.hasVariations = hasVariations;
    }

    public void setVariationId(ArrayList<String> variationId) {
        this.variationId = variationId;
    }

    public void setProductAttributeArrayList(ArrayList<ProductAttribute> productAttributeArrayList) {
        this.productAttributeArrayList = productAttributeArrayList;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( this.getClass().getName() );
        result.append( " Object {" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(this) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }

    protected Product(Parcel in) {
        title = in.readString();
        id = in.readLong();
        long tmpCreated_at = in.readLong();
        created_at = tmpCreated_at != -1 ? new Date(tmpCreated_at) : null;
        long tmpUpdated_at = in.readLong();
        updated_at = tmpUpdated_at != -1 ? new Date(tmpUpdated_at) : null;
        type = in.readString();
        permalink = in.readString();
        sku = in.readString();
        price = in.readString();
        regular_price = in.readString();
        sale_price = in.readString();
        managing_stock = in.readByte() != 0x00;
        stock_quantity = in.readInt();
        in_stock = in.readByte() != 0x00;
        backorders_allowed = in.readByte() != 0x00;
        backordered = in.readByte() != 0x00;
        sold_individually = in.readByte() != 0x00;
        featured = in.readByte() != 0x00;
        visible = in.readByte() != 0x00;
        catalog_visibility = in.readString();
        on_sale = in.readByte() != 0x00;
        product_url = in.readString();
        button_text = in.readString();
        weight = in.readString();
        shipping_required = in.readByte() != 0x00;
        shipping_taxable = in.readByte() != 0x00;
        shipping_class = in.readString();
        shipping_class_id = in.readString();
        long_description = in.readString();
        short_description = in.readString();
        reviews_allowed = in.readByte() != 0x00;
        average_rating = in.readString();
        rating_count = in.readInt();
        if (in.readByte() == 0x01) {
            related_ids = new ArrayList<Long>();
            in.readList(related_ids, Long.class.getClassLoader());
        } else {
            related_ids = null;
        }
        if (in.readByte() == 0x01) {
            upsell_ids = new ArrayList<Long>();
            in.readList(upsell_ids, Long.class.getClassLoader());
        } else {
            upsell_ids = null;
        }
        if (in.readByte() == 0x01) {
            cross_sell_ids = new ArrayList<Long>();
            in.readList(cross_sell_ids, Long.class.getClassLoader());
        } else {
            cross_sell_ids = null;
        }
        parent_id = in.readLong();
        if (in.readByte() == 0x01) {
            categories = new ArrayList<String>();
            in.readList(categories, String.class.getClassLoader());
        } else {
            categories = null;
        }
        if (in.readByte() == 0x01) {
            tags = new ArrayList<String>();
            in.readList(tags, String.class.getClassLoader());
        } else {
            tags = null;
        }
        if (in.readByte() == 0x01) {
            productImages = new ArrayList<ProductImage>();
            in.readList(productImages, ProductImage.class.getClassLoader());
        } else {
            productImages = null;
        }
        featured_image_url = in.readString();
        total_sales = in.readInt();
        hasVariations = in.readByte() != 0x00;
        if (in.readByte() == 0x01) {
            variationId = new ArrayList<String>();
            in.readList(variationId, String.class.getClassLoader());
        } else {
            variationId = null;
        }
        if (in.readByte() == 0x01) {
            productAttributeArrayList = new ArrayList<ProductAttribute>();
            in.readList(productAttributeArrayList, ProductAttribute.class.getClassLoader());
        } else {
            productAttributeArrayList = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeLong(id);
        dest.writeLong(created_at != null ? created_at.getTime() : -1L);
        dest.writeLong(updated_at != null ? updated_at.getTime() : -1L);
        dest.writeString(type);
        dest.writeString(permalink);
        dest.writeString(sku);
        dest.writeString(price);
        dest.writeString(regular_price);
        dest.writeString(sale_price);
        dest.writeByte((byte) (managing_stock ? 0x01 : 0x00));
        dest.writeInt(stock_quantity);
        dest.writeByte((byte) (in_stock ? 0x01 : 0x00));
        dest.writeByte((byte) (backorders_allowed ? 0x01 : 0x00));
        dest.writeByte((byte) (backordered ? 0x01 : 0x00));
        dest.writeByte((byte) (sold_individually ? 0x01 : 0x00));
        dest.writeByte((byte) (featured ? 0x01 : 0x00));
        dest.writeByte((byte) (visible ? 0x01 : 0x00));
        dest.writeString(catalog_visibility);
        dest.writeByte((byte) (on_sale ? 0x01 : 0x00));
        dest.writeString(product_url);
        dest.writeString(button_text);
        dest.writeString(weight);
        dest.writeByte((byte) (shipping_required ? 0x01 : 0x00));
        dest.writeByte((byte) (shipping_taxable ? 0x01 : 0x00));
        dest.writeString(shipping_class);
        dest.writeString(shipping_class_id);
        dest.writeString(long_description);
        dest.writeString(short_description);
        dest.writeByte((byte) (reviews_allowed ? 0x01 : 0x00));
        dest.writeString(average_rating);
        dest.writeInt(rating_count);
        if (related_ids == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(related_ids);
        }
        if (upsell_ids == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(upsell_ids);
        }
        if (cross_sell_ids == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(cross_sell_ids);
        }
        dest.writeLong(parent_id);
        if (categories == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(categories);
        }
        if (tags == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(tags);
        }
        if (productImages == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(productImages);
        }
        dest.writeString(featured_image_url);
        dest.writeInt(total_sales);
        dest.writeByte((byte) (hasVariations ? 0x01 : 0x00));
        if (variationId == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(variationId);
        }
        if (productAttributeArrayList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(productAttributeArrayList);
        }
    }

    @SuppressWarnings("unused")
    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}