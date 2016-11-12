package com.mohanfoundation.mohanfoundation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CounselorLogin extends AppCompatActivity{
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_login);
    }

    public void navigateToCommentsPage(View view) {

        username = (EditText) findViewById(R.id.username);
        String name = username.getText().toString();
        password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString();


        System.out.println(name);
        System.out.println(password);

    }

}
