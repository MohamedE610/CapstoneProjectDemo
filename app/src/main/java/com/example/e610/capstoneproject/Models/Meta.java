
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Meta implements Parcelable
{

    public Integer count;
    public final static Creator<Meta> CREATOR = new Creator<Meta>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Meta createFromParcel(Parcel in) {
            Meta instance = new Meta();
            instance.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Meta[] newArray(int size) {
            return (new Meta[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
    }

    public int describeContents() {
        return  0;
    }

}
