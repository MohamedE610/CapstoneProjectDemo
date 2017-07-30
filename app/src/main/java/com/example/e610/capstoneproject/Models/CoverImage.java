
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CoverImage implements Parcelable
{

    public String tiny;
    public String small;
    public String large;
    public String original;
    public final static Creator<CoverImage> CREATOR = new Creator<CoverImage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CoverImage createFromParcel(Parcel in) {
            CoverImage instance = new CoverImage();
            instance.tiny = ((String) in.readValue((String.class.getClassLoader())));
            instance.small = ((String) in.readValue((String.class.getClassLoader())));
            instance.large = ((String) in.readValue((String.class.getClassLoader())));
            instance.original = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public CoverImage[] newArray(int size) {
            return (new CoverImage[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tiny);
        dest.writeValue(small);
        dest.writeValue(large);
        dest.writeValue(original);
    }

    public int describeContents() {
        return  0;
    }

}
