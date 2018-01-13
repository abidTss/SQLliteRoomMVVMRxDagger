package com.abid.sqlliteandroom.mvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by abid on 13/1/18.
 */

public class PdfItemModel {
    @SerializedName("ID")
    @Expose
    public String id;

    @SerializedName("TCPTitle")
    @Expose
    public String TCPTitle;

    @SerializedName("Teachday")
    @Expose
    public String teachDay;
}
