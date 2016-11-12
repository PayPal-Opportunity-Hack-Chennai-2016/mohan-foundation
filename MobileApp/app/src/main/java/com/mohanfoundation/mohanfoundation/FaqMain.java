package com.mohanfoundation.mohanfoundation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FaqMain extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_main);
        ImageView faq_brain =(ImageView)findViewById(R.id.faq_brain);
        ImageView faq_liver =(ImageView)findViewById(R.id.faq_liver);
        ImageView faq_donate_organ =(ImageView)findViewById(R.id.faq_donate_organ);
        ImageView faq_kidney =(ImageView)findViewById(R.id.faq_kidney);

        TextView textView_brain =(TextView)findViewById(R.id.textView_brain);
        TextView textView_liver =(TextView)findViewById(R.id.textView_liver);
        TextView textView_donate_organs =(TextView)findViewById(R.id.textView_donate_organs);
        TextView textView_kidney =(TextView)findViewById(R.id.textView_kidney);

         faq_brain.setOnClickListener(this);
         faq_liver.setOnClickListener(this);
         faq_donate_organ.setOnClickListener(this);
         faq_kidney.setOnClickListener(this);

         textView_brain.setOnClickListener(this);
         textView_liver.setOnClickListener(this);
         textView_donate_organs.setOnClickListener(this);
         textView_kidney.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.faq_brain:
                Intent faq_braindead_intent = new Intent(getApplicationContext(),FaqBrainDead.class);
                startActivity(faq_braindead_intent);
                break;
            case R.id.textView_brain:
                Intent textview_braindead_intent = new Intent(getApplicationContext(),FaqBrainDead.class);
                startActivity(textview_braindead_intent);
                break;

            case R.id.faq_liver:
                Intent faq_liver_intent = new Intent(getApplicationContext(),FaqLiver.class);
                startActivity(faq_liver_intent);
                break;
            case R.id.textView_liver:
                Intent textView_liver_intent = new Intent(getApplicationContext(),FaqLiver.class);
                startActivity(textView_liver_intent);
                break;

            case R.id.faq_donate_organ:
                Intent faq_donate_organ_intent = new Intent(getApplicationContext(),FaqOrganDonation.class);
                startActivity(faq_donate_organ_intent);
                break;
            case R.id.textView_donate_organs:
                Intent textView_donate_organs = new Intent(getApplicationContext(),FaqOrganDonation.class);
                startActivity(textView_donate_organs);
                break;

            case R.id.faq_kidney:
                Intent faq_kidney_intent = new Intent(getApplicationContext(),FaqKidney.class);
                startActivity(faq_kidney_intent);
                break;
            case R.id.textView_kidney:
                Intent textView_kidney_intent = new Intent(getApplicationContext(),FaqKidney.class);
                startActivity(textView_kidney_intent);
                break;
        }

    }
}
