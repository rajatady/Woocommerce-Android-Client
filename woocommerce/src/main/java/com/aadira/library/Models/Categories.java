package com.aadira.library.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Field;

/**
 * Created by kumardivyarajat on 04/01/16.
 */
public class Categories extends WCObject implements Parcelable {

    protected long id;
    protected String name;
    protected String slug;
    protected long parent_id;
    protected String description;
    protected String display;
    protected String image;
    protected int count;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public long getParent_id() {
        return parent_id;
    }

    public String getDescription() {
        return description;
    }

    public String getDisplay() {
        return display;
    }

    public String getImage() {
        return image;
    }

    public int getCount() {
        return count;
    }

    public Categories() {
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

    protected Categories(Parcel in) {
        id = in.readLong();
        name = in.readString();
        slug = in.readString();
        parent_id = in.readInt();
        description = in.readString();
        display = in.readString();
        image = in.readString();
        count = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(slug);
        dest.writeLong(parent_id);
        dest.writeString(description);
        dest.writeString(display);
        dest.writeString(image);
        dest.writeInt(count);
    }

    @SuppressWarnings("unused")
    public static final Creator<Categories> CREATOR = new Creator<Categories>() {
        @Override
        public Categories createFromParcel(Parcel in) {
            return new Categories(in);
        }

        @Override
        public Categories[] newArray(int size) {
            return new Categories[size];
        }
    };
}