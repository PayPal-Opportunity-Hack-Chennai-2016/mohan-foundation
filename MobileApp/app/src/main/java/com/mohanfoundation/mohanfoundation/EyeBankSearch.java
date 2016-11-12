package com.mohanfoundation.mohanfoundation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mohanfoundation.mohanfoundation.Repositories.EyeBackRepo;
import com.mohanfoundation.mohanfoundation.models.EyeBank;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EyeBankSearch extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_bank_search);

        mRecyclerView = (RecyclerView) findViewById(R.id.eyebank_receycle_view);


        mAdapter = new MyRecyclerViewAdapterEyeBank(getDataSet());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }


    private ArrayList<DataObjectEyeBank> getDataSet() {

        ArrayList results = new ArrayList<>();

        ArrayList<EyeBank> eyeBanksList = new ArrayList<>();
        EyeBackRepo eyeBackRepo = new EyeBackRepo(getApplicationContext());
        eyeBanksList = eyeBackRepo.getDataSets();

        for (EyeBank eyeBank : eyeBanksList) {
            DataObjectEyeBank dataObjectEyeBank = new DataObjectEyeBank(eyeBank.state, eyeBank.city, eyeBank.nameOfEyebank, eyeBank.postalAddress, eyeBank.phone, eyeBank.email);
            results.add(dataObjectEyeBank);
        }

        return results;
    }

}
