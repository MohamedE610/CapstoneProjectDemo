
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Reviews implements Parcelable
{

    public Links links;
    public final static Creator<Reviews> CREATOR = new Creator<Reviews>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Reviews createFromParcel(Parcel in) {
            Reviews instance = new Reviews();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Reviews[] newArray(int size) {
            return (new Reviews[size]);
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
