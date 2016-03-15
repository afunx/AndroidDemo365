package com.afunx.aidlparcelableusage;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by afunx on 16-2-27.
 */
public class MyParcelable implements Parcelable {

    private Date mDate;
    private String mDetails;
    private double mPrice;

    public MyParcelable(Date date, String details, double price) {
        mDate = date;
        mDetails = details;
        mPrice = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    private MyParcelable(Parcel src) {
        mDate = new Date();
        mDate.setTime(src.readLong());
        mDetails = src.readString();
        mPrice = src.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mDate.getTime());
        dest.writeString(mDetails);
        dest.writeDouble(mPrice);
    }

    @Override
    public String toString() {
        return "[mDate = " + mDate + ", mDetails = " + mDetails + ", mPrice = " + mPrice;
    }


    public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {

        @Override
        public MyParcelable createFromParcel(Parcel source) {
            return new MyParcelable(source);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
}
