
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AnimeStaff implements Parcelable
{

    public Links links;
    public final static Creator<AnimeStaff> CREATOR = new Creator<AnimeStaff>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AnimeStaff createFromParcel(Parcel in) {
            AnimeStaff instance = new AnimeStaff();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public AnimeStaff[] newArray(int size) {
            return (new AnimeStaff[size]);
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
