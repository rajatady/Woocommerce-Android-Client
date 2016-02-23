package com.aadira.library.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by kumardivyarajat on 10/01/16.
 */
public class ProductImage extends WCObject implements Parcelable {

    public ProductImage() {
    }

    long id;
    Date created_at;
    Date updated_at;
    String src;
    String title;
    String alt;
    int position;

    public String getSrc() {
        return src;
    }

    protected ProductImage(Parcel in) {
        id = in.readLong();
        long tmpCreated_at = in.readLong();
        created_at = tmpCreated_at != -1 ? new Date(tmpCreated_at) : null;
        long tmpUpdated_at = in.readLong();
        updated_at = tmpUpdated_at != -1 ? new Date(tmpUpdated_at) : null;
        src = in.readString();
        title = in.readString();
        alt = in.readString();
        position = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(created_at != null ? created_at.getTime() : -1L);
        dest.writeLong(updated_at != null ? updated_at.getTime() : -1L);
        dest.writeString(src);
        dest.writeString(title);
        dest.writeString(alt);
        dest.writeInt(position);
    }

    @SuppressWarnings("unused")
    public static final Creator<ProductImage> CREATOR = new Creator<ProductImage>() {
        @Override
        public ProductImage createFromParcel(Parcel in) {
            return new ProductImage(in);
        }

        @Override
        public ProductImage[] newArray(int size) {
            return new ProductImage[size];
        }
    };
}
