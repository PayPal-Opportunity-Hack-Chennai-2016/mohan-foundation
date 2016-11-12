package com.mohanfoundation.mohanfoundation;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class HomeScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn_eye_banks = (Button) findViewById(R.id.btn_eye_banks);
        Button btn_skin_banks = (Button) findViewById(R.id.btn_skin_banks);
        Button btn_body_donation = (Button) findViewById(R.id.btn_body_donation);
        Button btn_donation_hospitals = (Button) findViewById(R.id.btn_donation_hospitals);
        Button btn_ngo_list = (Button) findViewById(R.id.btn_ngo_list);
        Button btn_transplant_centres = (Button) findViewById(R.id.btn_transplant_centres);

        TextView textView_faq = (TextView) findViewById(R.id.textView_faq);
        TextView textView_join_members = (TextView) findViewById(R.id.textView_join_members);
        TextView textView_pledge = (TextView) findViewById(R.id.textView_pledge);

        btn_eye_banks.setOnClickListener(this);
        btn_skin_banks.setOnClickListener(this);
        btn_body_donation.setOnClickListener(this);
        btn_donation_hospitals.setOnClickListener(this);
        btn_ngo_list.setOnClickListener(this);
        btn_transplant_centres.setOnClickListener(this);

        textView_faq.setOnClickListener(this);
        textView_join_members.setOnClickListener(this);
        textView_pledge.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent login_intent = new Intent(getApplicationContext(), CounselorLogin.class);
            startActivity(login_intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.btn_eye_banks:

                break;
            case R.id.btn_skin_banks:


                break;
            case R.id.btn_body_donation:


                break;
            case R.id.btn_donation_hospitals:


                break;
            case R.id.btn_ngo_list:


                break;
            case R.id.btn_transplant_centres:


                break;
            case R.id.textView_faq:
                Intent FaqMain_intent = new Intent(getApplicationContext(), FaqMain.class);
                startActivity(FaqMain_intent);

                break;
            case R.id.textView_pledge:
                String join_member_url = "http://www.mohanfoundation.org/download_donorcard.asp";
                Intent join_member_intent = new Intent(Intent.ACTION_VIEW);
                join_member_intent.setData(Uri.parse(join_member_url));
                startActivity(join_member_intent);


                break;
            case R.id.textView_join_members:
                String pledge_url = "http://www.mohanfoundation.org/life-membership.asp";
                Intent pledge_intent = new Intent(Intent.ACTION_VIEW);
                pledge_intent.setData(Uri.parse(pledge_url));
                startActivity(pledge_intent);

                break;

        }

    }
}
