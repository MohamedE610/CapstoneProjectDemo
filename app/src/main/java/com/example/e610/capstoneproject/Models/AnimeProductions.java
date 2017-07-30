
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AnimeProductions implements Parcelable
{

    public Links links;
    public final static Creator<AnimeProductions> CREATOR = new Creator<AnimeProductions>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AnimeProductions createFromParcel(Parcel in) {
            AnimeProductions instance = new AnimeProductions();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public AnimeProductions[] newArray(int size) {
            return (new AnimeProductions[size]);
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
