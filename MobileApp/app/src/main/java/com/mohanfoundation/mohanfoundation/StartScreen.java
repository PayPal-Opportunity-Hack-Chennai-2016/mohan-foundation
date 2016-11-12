package com.mohanfoundation.mohanfoundation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mohanfoundation.mohanfoundation.Repositories.EyeBackRepo;
import com.mohanfoundation.mohanfoundation.models.EyeBank;
import com.wang.avi.AVLoadingIndicatorView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

import okhttp3.*;

public class StartScreen extends AppCompatActivity {

    public static Gson GSON = new Gson();
    public AVLoadingIndicatorView indicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        indicatorView =(AVLoadingIndicatorView)findViewById(R.id.avi);
        startAnim();
        try {
            getEyeBankDetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getEyeBankDetails() throws IOException {


        final Request requestOutBound = new Request.Builder()
                .url("http://mohan-93120.onmodulus.net/crud/rest/list/eyebank")
                .get()
                .build();


        OkHttpClient client = new OkHttpClient();

        client.newCall(requestOutBound).enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

                Log.d("postUrl", "Failure");


            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                Type collectionType = new TypeToken<Collection<EyeBank>>(){}.getType();
                Collection<EyeBank> eyeBanks = GSON.fromJson(response.body().string(), collectionType);
                EyeBackRepo eyeBackRepo = new EyeBackRepo(getApplicationContext());
                int reponseFromDb=eyeBackRepo.insert(eyeBanks);
                if(reponseFromDb>0)
                {
                    Intent goToHomeScreen = new Intent(getApplicationContext(),HomeScreen.class);
                    startActivity(goToHomeScreen);
                }

            }


        });




    }


    void startAnim(){
        indicatorView.show();
        // or avi.smoothToShow();
    }

    void stopAnim(){
        indicatorView.hide();
        // or avi.smoothToHide();
    }
}
