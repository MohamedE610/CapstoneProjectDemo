
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Titles implements Parcelable
{

    public String en;
    public String enJp;
    public String jaJp;
    public final static Creator<Titles> CREATOR = new Creator<Titles>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Titles createFromParcel(Parcel in) {
            Titles instance = new Titles();
            instance.en = ((String) in.readValue((String.class.getClassLoader())));
            instance.enJp = ((String) in.readValue((String.class.getClassLoader())));
            instance.jaJp = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Titles[] newArray(int size) {
            return (new Titles[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(en);
        dest.writeValue(enJp);
        dest.writeValue(jaJp);
    }

    public int describeContents() {
        return  0;
    }

}
