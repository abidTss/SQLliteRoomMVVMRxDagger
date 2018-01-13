package com.abid.sqlliteandroom.mvvm.viewmodels;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.abid.sqlliteandroom.ApiInterFace;
import com.abid.sqlliteandroom.PdfData;
import com.abid.sqlliteandroom.mvvm.model.PdfItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by abid on 13/1/18.
 */

public class PdfViewModel extends Observable {

    private List<PdfItemModel> pdfItemModelList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PdfViewModel(Context context) {
        this.context = context;
        this.pdfItemModelList = new ArrayList<>();
    }

    public List<PdfItemModel> getPdfList() {
        return pdfItemModelList;
    }
    /*Sales Person Retail$14*/
    public void loadData(Retrofit retrofit) {
        Disposable observable5 = retrofit.create(ApiInterFace.class).getPosts(1, 100, "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult, this::handleError);
        compositeDisposable.add(observable5);

    }

    private void handleError(Throwable throwable) {
        Log.e("Retrofit error", "is - " + throwable.toString());
        Toast.makeText(context, "There was something wrong", Toast.LENGTH_SHORT).show();
    }

    private void handleResult(PdfData pdfData) {
        updateUserDataList(pdfData.list);
    }

    private void updateUserDataList(List<PdfItemModel> list) {
        pdfItemModelList.addAll(list);
        setChanged();
        notifyObservers();
    }
    private void unSubscribeFromObservable() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public void reset() {
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }

}
