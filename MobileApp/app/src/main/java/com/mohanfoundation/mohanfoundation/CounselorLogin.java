package com.mohanfoundation.mohanfoundation;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class CounselorLogin extends AppCompatActivity{
    private EditText username;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counselor_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        username.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    password.requestFocus();
                }
                return false;
            }
        });
        password.setOnEditorActionListener(new EditText.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    try {
                        navigateToCommentsPage();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });

    }

    public void navigateToCommentsPage(View view) {

        String[] emailids=new String[]{"hemal@mohanfoundation.org","kavitha@mohanfoundation.org","ragavan@mohanfoundations.org"};
        String[] passwords=new String[]{"7708668830","9447691127","9444607000"};
        username = (EditText) findViewById(R.id.username);
        String emailid = username.getText().toString();
        password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString();


        for (int i=0;i<emailids.length;i++)
        {
           if(emailids[i].equals(emailid))
           {
               Intent goToComments = new Intent(getApplicationContext(),AddComments.class);
               startActivity(goToComments);
               break;
           }
        }

        alertDialogBox();


     }

    public void navigateToCommentsPage() {

        String[] emailids={"hemal@mohanfoundation.org","kavitha@mohanfoundation.org","ragavan@mohanfoundations.org"};
        String[] passwords={"7708668830","9447691127","9444607000"};
        username = (EditText) findViewById(R.id.username);
        String emailid = username.getText().toString();
        password = (EditText) findViewById(R.id.password);
        String pass = password.getText().toString();

        for (int i=0;i<emailids.length;i++)
        {
            System.out.println(emailids[i]);
            System.out.println(emailid);
            if(emailids[i].equals(emailid))
            {
                Intent goToComments = new Intent(getApplicationContext(),AddComments.class);
                goToComments.putExtra("email",emailid);
                startActivity(goToComments);
            }
        }

        alertDialogBox();


    }
    public void alertDialogBox() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Sorry! You are not an authorized counsellor.This feature is only available to MOHAN Foundation Counsellors");

        alertDialogBuilder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
