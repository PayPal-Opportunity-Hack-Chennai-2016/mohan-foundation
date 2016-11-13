package com.mohanfoundation.mohanfoundation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.mohanfoundation.mohanfoundation.Repositories.EyeBackRepo;
import com.mohanfoundation.mohanfoundation.Repositories.NgoListRepo;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.mohanfoundation.mohanfoundation.models.NGOlist;

import java.util.ArrayList;

public class NGOSearch extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_bank_search);

        final EditText searchCity = (EditText) findViewById(R.id.eyebank_search_city);


        mRecyclerView = (RecyclerView) findViewById(R.id.eyebank_receycle_view);


        mAdapter = new MyRecyclerViewAdapterEyeBank(getDataSet());
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);


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
    }

    private ArrayList<DataObjectEyeBank> getDataSet() {

        ArrayList results = new ArrayList<>();

        ArrayList<NGOlist> eyeBanksList = new ArrayList<>();
        NgoListRepo eyeBackRepo = new NgoListRepo(getApplicationContext());
        eyeBanksList = eyeBackRepo.getDataSets();

        for (NGOlist eyeBank : eyeBanksList) {
            DataObjectEyeBank dataObjectEyeBank = new DataObjectEyeBank(eyeBank.state, eyeBank.city, eyeBank.nameOfNgo, eyeBank.postalAddress, eyeBank.phone);
            results.add(dataObjectEyeBank);
        }

        return results;
    }

    private ArrayList<DataObjectEyeBank> getSearchResultDataSetCity(String searchQuery) {

        ArrayList results = new ArrayList<>();

        ArrayList<NGOlist> eyeBanksList = new ArrayList<>();
        NgoListRepo eyeBackRepo = new NgoListRepo(getApplicationContext());
        eyeBanksList = eyeBackRepo.getSearchResultDataSetCity(searchQuery);

        for (NGOlist eyeBank : eyeBanksList) {
            DataObjectEyeBank dataObjectEyeBank = new DataObjectEyeBank(eyeBank.state, eyeBank.city, eyeBank.nameOfNgo, eyeBank.postalAddress, eyeBank.phone);
            results.add(dataObjectEyeBank);
        }

        return results;
    }

}
