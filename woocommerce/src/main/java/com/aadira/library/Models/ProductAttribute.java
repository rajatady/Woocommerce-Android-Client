package com.aadira.library.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by kumardivyarajat on 10/01/16.
 */
public class ProductAttribute extends WCObject implements Parcelable {


    public ProductAttribute() {
    }

    private String name;
    private String slug;
    private int position;
    private boolean visible;
    private boolean variations;
    private ArrayList<String> options;

    protected ProductAttribute(Parcel in) {
        name = in.readString();
        slug = in.readString();
        position = in.readInt();
        visible = in.readByte() != 0x00;
        variations = in.readByte() != 0x00;
        if (in.readByte() == 0x01) {
            options = new ArrayList<String>();
            in.readList(options, String.class.getClassLoader());
        } else {
            options = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(slug);
        dest.writeInt(position);
        dest.writeByte((byte) (visible ? 0x01 : 0x00));
        dest.writeByte((byte) (variations ? 0x01 : 0x00));
        if (options == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(options);
        }
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVariations() {
        return variations;
    }

    public void setVariations(boolean variations) {
        this.variations = variations;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    @SuppressWarnings("unused")
    public static final Creator<ProductAttribute> CREATOR = new Creator<ProductAttribute>() {
        @Override
        public ProductAttribute createFromParcel(Parcel in) {
            return new ProductAttribute(in);
        }

        @Override
        public ProductAttribute[] newArray(int size) {
            return new ProductAttribute[size];
        }
    };
}
