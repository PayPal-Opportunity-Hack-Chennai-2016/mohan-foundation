package com.mohanfoundation.mohanfoundation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.mohanfoundation.mohanfoundation.Repositories.EyeBackRepo;
import com.mohanfoundation.mohanfoundation.Repositories.TransplantRepo;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.mohanfoundation.mohanfoundation.models.TrasnplantHospital;

import java.util.ArrayList;

public class TransplantSearch extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transplant_search);




        mRecyclerView = (RecyclerView) findViewById(R.id.eyebank_receycle_view);


        mAdapter = new MyRecyclerViewAdapterEyeBank(getDataSet());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);


        final EditText searchCity = (EditText) findViewById(R.id.eyebank_search_city1);
        final EditText searchOrgan = (EditText) findViewById(R.id.eyebank_organ_city);

        searchCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int lengthOfString = searchCity.getText().toString().length();
                String searchQuery= searchCity.getText().toString();

                if(lengthOfString>3)
                {
                    mAdapter = new MyRecyclerViewAdapterEyeBank(getSearchResultDataSetCity(searchQuery));
                    mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(mLayoutManager);

                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
                    mRecyclerView.addItemDecoration(itemDecoration);
                }
                if(lengthOfString<1)
                {
                    mAdapter = new MyRecyclerViewAdapterEyeBank(getDataSet());
                    mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(mLayoutManager);

                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
                    mRecyclerView.addItemDecoration(itemDecoration);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        searchOrgan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int lengthOfString =  searchOrgan.getText().toString().length();
                String searchQuery=  searchOrgan.getText().toString();

                if(lengthOfString>3)
                {
                    mAdapter = new MyRecyclerViewAdapterEyeBank(getSearchResultDataSetOrgan(searchQuery));
                    mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(mLayoutManager);

                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
                    mRecyclerView.addItemDecoration(itemDecoration);
                }
                if(lengthOfString<1)
                {
                    mAdapter = new MyRecyclerViewAdapterEyeBank(getDataSet());
                    mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(mLayoutManager);

                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL);
                    mRecyclerView.addItemDecoration(itemDecoration);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });



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

    private ArrayList<DataObjectEyeBank> getSearchResultDataSetCity(String searchQuery) {

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

    private ArrayList<DataObjectEyeBank> getSearchResultDataSetOrgan(String searchQuery) {

        ArrayList results = new ArrayList<>();

        ArrayList<TrasnplantHospital> eyeBanksList = new ArrayList<>();
        TransplantRepo eyeBackRepo = new TransplantRepo(getApplicationContext());
        eyeBanksList = eyeBackRepo.getSearchResultDataSetOrgan(searchQuery);

        for (TrasnplantHospital eyeBank : eyeBanksList) {
            DataObjectEyeBank dataObjectEyeBank = new DataObjectEyeBank(eyeBank.organCategory, eyeBank.city, eyeBank.hospitalName, eyeBank.postalAddress, eyeBank.phone);
            results.add(dataObjectEyeBank);
        }

        return results;
    }
}
