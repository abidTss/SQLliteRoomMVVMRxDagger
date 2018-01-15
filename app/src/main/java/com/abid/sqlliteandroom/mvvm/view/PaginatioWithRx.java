package com.abid.sqlliteandroom.mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.abid.sqlliteandroom.R;
import com.abid.sqlliteandroom.databinding.PaginationWithrxBinding;
import com.abid.sqlliteandroom.mvvm.viewmodels.PdfViewModel;

import javax.inject.Inject;

/**
 * Created by abid on 15/1/18.
 */

public class PaginatioWithRx extends AppCompatActivity {
    PaginationWithrxBinding paginationWithrxBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        paginationWithrxBinding = DataBindingUtil.setContentView(this, R.layout.pagination_withrx);
        //paginationWithrxBinding.rlView.setLayoutManager();
    }
}
