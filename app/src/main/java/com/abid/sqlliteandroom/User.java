package com.abid.sqlliteandroom;

import android.arch.persistence.room.Entity;

/**
 * Created by abid on 11/26/17.
 */

public class User {

    String title;
    String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
