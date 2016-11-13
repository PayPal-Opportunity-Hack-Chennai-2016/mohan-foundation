package com.mohanfoundation.mohanfoundation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.reflect.TypeToken;
import com.mohanfoundation.mohanfoundation.Repositories.TransplantRepo;
import com.mohanfoundation.mohanfoundation.models.TrasnplantHospital;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddComments extends AppCompatActivity {
    private Handler mHandler;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comments);

        final EditText message = (EditText)findViewById(R.id.editText2);
        Intent i = getIntent();
        final String email= i.getStringExtra("email");
        Date dt = new Date();
        final String date = dt.toString();

        mContext = this;
        mHandler = new Handler(Looper.getMainLooper());

        Button submit = (Button)findViewById(R.id.Submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");
                RequestBody body = RequestBody.create(JSON, "{\"email\":\"kavitha@mohan\",\"time\":\""+date+"\",\"message\":\""+message.getText().toString()+"\"}");

                final Request requestOutBound = new Request.Builder()
                        .url("http://mohan-93120.onmodulus.net/crud/rest/cnsmsg")
                        .post(body)
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
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {

                                alertDialogBox();

                            }
                        });

                    }


                });

            }
        });
    }


    public void alertDialogBox() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("You Comment has been successfully added");

        alertDialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             Intent backToHome = new Intent(getApplicationContext(),HomeScreen.class);
                startActivity(backToHome);

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
