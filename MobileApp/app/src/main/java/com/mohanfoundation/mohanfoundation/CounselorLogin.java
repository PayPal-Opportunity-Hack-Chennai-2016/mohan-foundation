package com.mohanfoundation.mohanfoundation;

import android.content.Intent;
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

        String[] emailids={"hemal@mohanfoundation.org","kavitha@mohanfoundation.org","ragavan@mohanfoundations.org"};
        String[] passwords={"7708668830","9447691127","9444607000"};
        username = (EditText) findViewById(R.id.username);
        String emailid = username.getText().toString();
        password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString();

        for (int i=0;i<emailids.length;i++)
        {
           if(emailids[i]== emailid)
           {
               Intent goToComments = new Intent(getApplicationContext(),AddComments.class);
               startActivity(goToComments);
           }
        }

     }
}
