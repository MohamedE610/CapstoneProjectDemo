
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StreamingLinks implements Parcelable
{

    public Links links;
    public final static Creator<StreamingLinks> CREATOR = new Creator<StreamingLinks>() {


        @SuppressWarnings({
            "unchecked"
        })
        public StreamingLinks createFromParcel(Parcel in) {
            StreamingLinks instance = new StreamingLinks();
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public StreamingLinks[] newArray(int size) {
            return (new StreamingLinks[size]);
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
