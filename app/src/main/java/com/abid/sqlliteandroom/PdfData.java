package com.abid.sqlliteandroom;

import com.abid.sqlliteandroom.mvvm.model.PdfItemModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abid on 12/1/18.
 */

public class PdfData {
    @SerializedName("Key")
    @Expose
    public String Key;

    @SerializedName("Value")
    @Expose
    public List<PdfItemModel> list;
}
