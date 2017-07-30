
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Links implements Parcelable
{

    public String self;
    public String related;
    public final static Creator<Links> CREATOR = new Creator<Links>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links createFromParcel(Parcel in) {
            Links instance = new Links();
            instance.self = ((String) in.readValue((String.class.getClassLoader())));
            instance.related = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(related);
    }

    public int describeContents() {
        return  0;
    }

}
