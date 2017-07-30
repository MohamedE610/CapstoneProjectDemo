
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Mappings implements Parcelable
{

    public Links links;
    public final static Creator<Mappings> CREATOR = new Creator<Mappings>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Mappings createFromParcel(Parcel in) {
            Mappings instance = new Mappings();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Mappings[] newArray(int size) {
            return (new Mappings[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
