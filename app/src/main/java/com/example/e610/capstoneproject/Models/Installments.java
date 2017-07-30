
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Installments implements Parcelable
{

    public Links links;
    public final static Creator<Installments> CREATOR = new Creator<Installments>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Installments createFromParcel(Parcel in) {
            Installments instance = new Installments();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Installments[] newArray(int size) {
            return (new Installments[size]);
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
