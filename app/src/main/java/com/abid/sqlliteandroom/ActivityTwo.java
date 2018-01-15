package com.abid.sqlliteandroom;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abid.sqlliteandroom.databinding.ActivityMainLivedataBinding;
import com.abid.sqlliteandroom.mvvm.adapter.PdfActivityAdapter;
import com.abid.sqlliteandroom.mvvm.viewmodels.PdfViewModel;

import java.util.Observer;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;


/**
 * Created by abid on 4/1/18.
 */

public class ActivityTwo extends AppCompatActivity implements Observer {

    @Inject
    Retrofit retrofit;

    PdfViewModel pdfViewModel;

    private String TAG = ActivityTwo.class.getName();
    ActivityMainLivedataBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_livedata);
        // ButterKnife.bind(this);
         ((AppClass) getApplication()).getNetComponent().inject(this);
        initDataBinding();
        setupRecyclerView(binding.recyclerView);
        setupObserver(pdfViewModel);
        pdfViewModel.loadData(retrofit);
    }


    private void initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_livedata);
        pdfViewModel = new PdfViewModel(this);
        binding.setPdfViewModel(pdfViewModel);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        PdfActivityAdapter pdfActivityAdapter = new PdfActivityAdapter();
        recyclerView.setAdapter(pdfActivityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupObserver(PdfViewModel pdfViewModel) {
        pdfViewModel.addObserver(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pdfViewModel.reset();
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        if (o instanceof PdfViewModel) {
            PdfActivityAdapter pdfActivityAdapter = (PdfActivityAdapter) binding.recyclerView.getAdapter();
            PdfViewModel pdfViewModel= (PdfViewModel) o;
            pdfActivityAdapter.setUserList(pdfViewModel.getPdfList());
        }
    }

}
