package com.abid.sqlliteandroom.mvvm.viewmodels;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.abid.sqlliteandroom.mvvm.model.PdfItemModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


/**
 * Created by abid on 13/1/18.
 */

public class PdfItemViewModel extends BaseObservable {

    private PdfItemModel pdfItemModel;
    private Context context;

    public PdfItemViewModel(PdfItemModel pdfItemModel, Context context) {
        this.context = context;
        this.pdfItemModel = pdfItemModel;
    }

    public String getId() {
        return pdfItemModel.id;
    }

    public String getTCPTitle(){
        return pdfItemModel.TCPTitle;
    }
    public String getTeachDay(){
        return pdfItemModel.teachDay;
    }
    public void setPdfItem(PdfItemModel pdfItemModel){
        this.pdfItemModel=pdfItemModel;
        notifyChange();
    }

    public String getTCPDescription(){
        return pdfItemModel.TCPDescription;
    }

    public String getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return "www.teastallstudio.com/asset/60677654.jpg";
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .applyDefaultRequestOptions(new RequestOptions().placeholder(android.R.drawable.arrow_down_float))
                .load(imageUrl)
                .into(view);
    }



}
