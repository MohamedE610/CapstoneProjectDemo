
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Episodes implements Parcelable
{

    public Links links;
    public final static Creator<Episodes> CREATOR = new Creator<Episodes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Episodes createFromParcel(Parcel in) {
            Episodes instance = new Episodes();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Episodes[] newArray(int size) {
            return (new Episodes[size]);
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
