
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Castings implements Parcelable
{

    public Links links;
    public final static Creator<Castings> CREATOR = new Creator<Castings>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Castings createFromParcel(Parcel in) {
            Castings instance = new Castings();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Castings[] newArray(int size) {
            return (new Castings[size]);
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
