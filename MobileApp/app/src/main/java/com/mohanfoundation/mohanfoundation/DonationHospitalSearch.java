package com.mohanfoundation.mohanfoundation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mohanfoundation.mohanfoundation.Repositories.EyeBackRepo;
import com.mohanfoundation.mohanfoundation.Repositories.TransplantRepo;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.mohanfoundation.mohanfoundation.models.TrasnplantHospital;

import java.util.ArrayList;
import java.util.concurrent.TransferQueue;

public class DonationHospitalSearch extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_bank_search);

       /* final Spinner searchCity = (Spinner) findViewById(R.id.eyebank_search_city);*/


        mRecyclerView = (RecyclerView) findViewById(R.id.eyebank_receycle_view);


        mAdapter = new MyRecyclerViewAdapterEyeBank(getDataSet());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);


       /* searchCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                String items = searchCity.getSelectedItem().toString();
                mAdapter = new MyRecyclerViewAdapterEyeBank(getSearchResultDataSet(items));
                mLayoutManager = new LinearLayoutManager(getApplicationContext());
                mRecyclerView.setLayoutManager(mLayoutManager);

                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
                mRecyclerView.addItemDecoration(itemDecoration);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });*/



    }

    private ArrayList<DataObjectEyeBank> getDataSet() {

        ArrayList results = new ArrayList<>();

        ArrayList<TrasnplantHospital> eyeBanksList = new ArrayList<>();
        TransplantRepo eyeBackRepo = new TransplantRepo(getApplicationContext());
        eyeBanksList = eyeBackRepo.getDataSets();

        for (TrasnplantHospital eyeBank : eyeBanksList) {
            DataObjectEyeBank dataObjectEyeBank = new DataObjectEyeBank(eyeBank.organCategory, eyeBank.city, eyeBank.hospitalName, eyeBank.postalAddress, eyeBank.phone);
            results.add(dataObjectEyeBank);
        }

        return results;
    }

    private ArrayList<DataObjectEyeBank> getSearchResultDataSet(String searchQuery) {

        ArrayList results = new ArrayList<>();

        ArrayList<TrasnplantHospital> eyeBanksList = new ArrayList<>();
        TransplantRepo eyeBackRepo = new TransplantRepo(getApplicationContext());
        eyeBanksList = eyeBackRepo.getSearchResultDataSetCity(searchQuery);

        for (TrasnplantHospital eyeBank : eyeBanksList) {
            DataObjectEyeBank dataObjectEyeBank = new DataObjectEyeBank(eyeBank.organCategory, eyeBank.city, eyeBank.hospitalName, eyeBank.postalAddress, eyeBank.phone);
            results.add(dataObjectEyeBank);
        }

        return results;
    }
}
