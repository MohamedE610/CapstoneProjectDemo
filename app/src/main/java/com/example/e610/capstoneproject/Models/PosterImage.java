
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PosterImage implements Parcelable
{

    public String tiny;
    public String small;
    public String medium;
    public String large;
    public String original;
    public final static Creator<PosterImage> CREATOR = new Creator<PosterImage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PosterImage createFromParcel(Parcel in) {
            PosterImage instance = new PosterImage();
            instance.tiny = ((String) in.readValue((String.class.getClassLoader())));
            instance.small = ((String) in.readValue((String.class.getClassLoader())));
            instance.medium = ((String) in.readValue((String.class.getClassLoader())));
            instance.large = ((String) in.readValue((String.class.getClassLoader())));
            instance.original = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public PosterImage[] newArray(int size) {
            return (new PosterImage[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tiny);
        dest.writeValue(small);
        dest.writeValue(medium);
        dest.writeValue(large);
        dest.writeValue(original);
    }

    public int describeContents() {
        return  0;
    }

}
