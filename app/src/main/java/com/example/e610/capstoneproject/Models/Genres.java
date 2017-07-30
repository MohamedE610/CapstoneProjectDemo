
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Genres implements Parcelable
{

    public Links links;
    public final static Creator<Genres> CREATOR = new Creator<Genres>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Genres createFromParcel(Parcel in) {
            Genres instance = new Genres();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Genres[] newArray(int size) {
            return (new Genres[size]);
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
