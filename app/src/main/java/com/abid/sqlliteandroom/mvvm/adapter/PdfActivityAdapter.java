package com.abid.sqlliteandroom.mvvm.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.abid.sqlliteandroom.R;


import com.abid.sqlliteandroom.databinding.RecyclerviewItemBinding;
import com.abid.sqlliteandroom.mvvm.model.PdfItemModel;
import com.abid.sqlliteandroom.mvvm.viewmodels.PdfItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by abid on 13/1/18.
 */

public class PdfActivityAdapter extends RecyclerView.Adapter<PdfActivityAdapter.AdapterViewHolder> {

    private List<PdfItemModel> list;

    public PdfActivityAdapter() {
        this.list = Collections.emptyList();
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerviewItemBinding recyclerviewItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.recyclerview_item, parent, false);

        return new AdapterViewHolder(recyclerviewItemBinding);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        PdfItemModel pdfItemModel = list.get(position);
        holder.onBinds(pdfItemModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {
        RecyclerviewItemBinding recyclerviewItemBinding;

        public AdapterViewHolder(RecyclerviewItemBinding recyclerviewItemBinding) {
            super(recyclerviewItemBinding.itempdf);
            this.recyclerviewItemBinding = recyclerviewItemBinding;
        }

        public void onBinds(PdfItemModel pdfItemModel) {
            if (recyclerviewItemBinding.getPdfItemViewModel() == null) {
                recyclerviewItemBinding.setPdfItemViewModel(new PdfItemViewModel(pdfItemModel, itemView.getContext()));
            } else {
                recyclerviewItemBinding.getPdfItemViewModel().setPdfItem(pdfItemModel);
            }
        }
    }

    public void setUserList(List<PdfItemModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
