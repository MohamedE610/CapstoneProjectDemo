
package com.example.e610.capstoneproject.Models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Example implements Parcelable
{

    public List<Datum> data = null;
    public Meta meta;
    public Links links;
    public final static Creator<Example> CREATOR = new Creator<Example>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Example createFromParcel(Parcel in) {
            Example instance = new Example();
            in.readList(instance.data, (com.example.e610.capstoneproject.Models.Datum.class.getClassLoader()));
            instance.meta = ((Meta) in.readValue((Meta.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Example[] newArray(int size) {
            return (new Example[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(data);
        dest.writeValue(meta);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
