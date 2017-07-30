
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AnimeCharacters implements Parcelable
{

    public Links links;
    public final static Creator<AnimeCharacters> CREATOR = new Creator<AnimeCharacters>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AnimeCharacters createFromParcel(Parcel in) {
            AnimeCharacters instance = new AnimeCharacters();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public AnimeCharacters[] newArray(int size) {
            return (new AnimeCharacters[size]);
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
