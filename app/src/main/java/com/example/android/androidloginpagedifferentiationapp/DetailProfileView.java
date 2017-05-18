package com.example.android.androidloginpagedifferentiationapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by omar on 24-01-2017.
 */
public class DetailProfileView extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_details_xmllayout);

        final TextView profileType = (TextView) findViewById(R.id.profileTypep);
        final TextView firstName = (TextView) findViewById(R.id.firstnamep);
        final TextView lastName = (TextView) findViewById(R.id.lastnamep);
        final TextView email = (TextView) findViewById(R.id.emailp);
        final TextView usertype = (TextView) findViewById(R.id.usertypep);

        Bundle extras = getIntent().getExtras();
        String[] recordsOfUser = extras.getStringArray("records");
        Toast.makeText(getApplicationContext(), "login Successfull", Toast.LENGTH_SHORT).show();

        String typecheck = recordsOfUser[3];


            if (typecheck.contains("admin")) {
                profileType.setText("This is Admin profile");

                firstName.setText(recordsOfUser[0]);
                firstName.setTextColor(getResources().getColor(R.color.AdminColor));

                lastName.setText(recordsOfUser[1]);
                lastName.setTextColor(getResources().getColor(R.color.AdminColor));

                email.setText(recordsOfUser[2]);
                email.setTextColor(getResources().getColor(R.color.AdminColor));

                usertype.setText(recordsOfUser[3]);
                usertype.setTextColor(getResources().getColor(R.color.AdminColor));

            }

            else if (typecheck.contains("user")) {
                profileType.setText("This is normal user Profile");

                firstName.setText(recordsOfUser[0]);
                firstName.setTextColor(getResources().getColor(R.color.normalUserColor));

                lastName.setText(recordsOfUser[1]);
                lastName.setTextColor(getResources().getColor(R.color.normalUserColor));

                email.setText(recordsOfUser[2]);
                email.setTextColor(getResources().getColor(R.color.normalUserColor));

                usertype.setText(recordsOfUser[3]);
                usertype.setTextColor(getResources().getColor(R.color.normalUserColor));

            }


    }
}
