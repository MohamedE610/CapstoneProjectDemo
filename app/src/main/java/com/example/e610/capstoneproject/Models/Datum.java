
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Datum implements Parcelable
{

    public String id;
    public String type;
    public Links links;
    public Attributes attributes;
    public Relationships relationships;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            Datum instance = new Datum();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            instance.attributes = ((Attributes) in.readValue((Attributes.class.getClassLoader())));
            instance.relationships = ((Relationships) in.readValue((Relationships.class.getClassLoader())));
            return instance;
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(type);
        dest.writeValue(links);
        dest.writeValue(attributes);
        dest.writeValue(relationships);
    }

    public int describeContents() {
        return  0;
    }

}
