
package com.example.e610.capstoneproject.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RatingFrequencies implements Parcelable
{

    public String _2;
    public String _3;
    public String _4;
    public String _5;
    public String _6;
    public String _7;
    public String _8;
    public String _9;
    public String _10;
    public String _11;
    public String _12;
    public String _13;
    public String _14;
    public String _15;
    public String _16;
    public String _17;
    public String _18;
    public String _19;
    public String _20;
    public final static Creator<RatingFrequencies> CREATOR = new Creator<RatingFrequencies>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RatingFrequencies createFromParcel(Parcel in) {
            RatingFrequencies instance = new RatingFrequencies();
            instance._2 = ((String) in.readValue((String.class.getClassLoader())));
            instance._3 = ((String) in.readValue((String.class.getClassLoader())));
            instance._4 = ((String) in.readValue((String.class.getClassLoader())));
            instance._5 = ((String) in.readValue((String.class.getClassLoader())));
            instance._6 = ((String) in.readValue((String.class.getClassLoader())));
            instance._7 = ((String) in.readValue((String.class.getClassLoader())));
            instance._8 = ((String) in.readValue((String.class.getClassLoader())));
            instance._9 = ((String) in.readValue((String.class.getClassLoader())));
            instance._10 = ((String) in.readValue((String.class.getClassLoader())));
            instance._11 = ((String) in.readValue((String.class.getClassLoader())));
            instance._12 = ((String) in.readValue((String.class.getClassLoader())));
            instance._13 = ((String) in.readValue((String.class.getClassLoader())));
            instance._14 = ((String) in.readValue((String.class.getClassLoader())));
            instance._15 = ((String) in.readValue((String.class.getClassLoader())));
            instance._16 = ((String) in.readValue((String.class.getClassLoader())));
            instance._17 = ((String) in.readValue((String.class.getClassLoader())));
            instance._18 = ((String) in.readValue((String.class.getClassLoader())));
            instance._19 = ((String) in.readValue((String.class.getClassLoader())));
            instance._20 = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public RatingFrequencies[] newArray(int size) {
            return (new RatingFrequencies[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_2);
        dest.writeValue(_3);
        dest.writeValue(_4);
        dest.writeValue(_5);
        dest.writeValue(_6);
        dest.writeValue(_7);
        dest.writeValue(_8);
        dest.writeValue(_9);
        dest.writeValue(_10);
        dest.writeValue(_11);
        dest.writeValue(_12);
        dest.writeValue(_13);
        dest.writeValue(_14);
        dest.writeValue(_15);
        dest.writeValue(_16);
        dest.writeValue(_17);
        dest.writeValue(_18);
        dest.writeValue(_19);
        dest.writeValue(_20);
    }

    public int describeContents() {
        return  0;
    }

}
