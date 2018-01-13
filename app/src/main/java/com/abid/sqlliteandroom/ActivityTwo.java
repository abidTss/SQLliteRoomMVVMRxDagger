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

        // getDataFromServer();
     /*   Observable<PdfData> observable5=retrofit.create(ApiInterFace.class).getPosts(1,100,"Sales Person Retail$14")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable5.subscribeOn(Schedulers.computation());
        observable5.observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResult,this::handleError);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new RecyclerViewAdapter());*/


        /*btnHitApi.setOnClickListener(View->
                retrofit.create(ApiInterFace.class).getPosts(1,100,"Sales Person Retail$14")
                        .enqueue(new Callback<PdfData>() {
                    @Override
                    public void onResponse(Call<PdfData> call, Response<PdfData> response) {
                        Log.e("response", "ayaya kya ni" + response.body());
                    }
                    @Override
                    public void onFailure(Call<PdfData> call, Throwable t) {
                        Log.e("response", "ayaya kya ni");
                    }
                }));*/
       /* Subscriber<PdfData> subscriber=new Subscriber<PdfData>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(PdfData pdfData) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };*/
     /*   Observer<PdfData> observer6=new Observer<PdfData>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(PdfData pdfData) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        observable5.subscribe(observer6);

        Observable<String> observable2=Observable.just("Abid khan");

        Observer<String> observer=new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

                Log.e("what observable emits :",s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        observable2.subscribe(observer);*/
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

    private void getDataFromServer() {
        /*Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

            }
        });*/

        Observable<Integer> observable = Observable.just(1, 2, 3, 4)
                .map(integer -> integer * 3).filter(integer -> integer % 2 == 0);
            /*.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(5);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(7);
            emitter.onComplete();
        });*/
/*
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer value) {
                Log.e(TAG, "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: All Done!");
            }
        };*/

        //Create our subscription//
        // observable.subscribe(observer);
    }

    private void handleResult(PdfData pdfData) {
        Log.e("recived data key ", " is " + pdfData.Key);

    }

    private void handleError(Throwable t) {
        Log.e("Observer", "" + t.toString());
        Toast.makeText(this, "ERROR IN GETTING COUPONS",
                Toast.LENGTH_LONG).show();
    }


    class RecyclerViewAdapter extends RecyclerView.Adapter<MyHolder> {
        LayoutInflater inflate;

        public RecyclerViewAdapter() {
            inflate = LayoutInflater.from(ActivityTwo.this);
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflate.inflate(R.layout.recyclerview_item, null);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);
        }
    }
}
