
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Categories implements Parcelable
{

    public Links links;
    public final static Creator<Categories> CREATOR = new Creator<Categories>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Categories createFromParcel(Parcel in) {
            Categories instance = new Categories();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Categories[] newArray(int size) {
            return (new Categories[size]);
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
