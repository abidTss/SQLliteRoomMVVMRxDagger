package com.abid.sqlliteandroom.mvvm.view;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abid on 15/1/18.
 */

public class User1 implements Parcelable {
    public int id;
    public String login;
    public String avatar_url;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.login);
        dest.writeString(this.avatar_url);
    }

    public User1() {
    }

    protected User1(Parcel in) {
        this.id = in.readInt();
        this.login = in.readString();
        this.avatar_url = in.readString();
    }

    public static final Parcelable.Creator<User1> CREATOR = new Parcelable.Creator<User1>() {
        @Override
        public User1 createFromParcel(Parcel source) {
            return new User1(source);
        }

        @Override
        public User1[] newArray(int size) {
            return new User1[size];
        }
    };
}
