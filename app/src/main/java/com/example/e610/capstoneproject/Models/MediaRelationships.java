
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaRelationships implements Parcelable
{

    public Links links;
    public final static Creator<MediaRelationships> CREATOR = new Creator<MediaRelationships>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MediaRelationships createFromParcel(Parcel in) {
            MediaRelationships instance = new MediaRelationships();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public MediaRelationships[] newArray(int size) {
            return (new MediaRelationships[size]);
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
