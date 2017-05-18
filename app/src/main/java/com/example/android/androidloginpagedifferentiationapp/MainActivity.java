package com.example.android.androidloginpagedifferentiationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    DatabaseHelperConnector databaseConnector = new DatabaseHelperConnector(this);
    Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText) findViewById(R.id.editTextUsername);
        final EditText password = (EditText) findViewById(R.id.editTextPass);

        final Button login = (Button) findViewById(R.id.buttonLogin);

        final Button register = (Button)findViewById(R.id.button2);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainActivity.this , RegisteringClass.class);
                startActivity(intent);

            }
        });




        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
               try {
                   List<String> userRecord = databaseConnector.getRecord(username.getEditableText().toString(), password.getEditableText().toString());

                    String[] records  = {userRecord.get(0),userRecord.get(1),userRecord.get(2),userRecord.get(3)};
                    intent = new Intent(MainActivity.this , DetailProfileView.class);
                    intent.putExtra("records" , records);
                    startActivity(intent);
//                    String typeChecking = userRecord.get(3);

//
//                    if(typeChecking.contains(admin)) {
//
//                        DetailProfileView.profileType.setText("This is Admin profile");
//
//                        DetailProfileView.firstName.setText(userRecord.get(0));
//                        DetailProfileView.firstName.setTextColor(getResources().getColor(R.color.AdminColor));
//
//                        DetailProfileView.lastName.setText(userRecord.get(1));
//                        DetailProfileView.lastName.setTextColor(getResources().getColor(R.color.AdminColor));
//
//                        DetailProfileView.email.setText(userRecord.get(2));
//                        DetailProfileView.email.setTextColor(getResources().getColor(R.color.AdminColor));
//
//                        DetailProfileView.usertype.setText(userRecord.get(3));
//                        DetailProfileView.usertype.setTextColor(getResources().getColor(R.color.AdminColor));
//                    }
//
//                    else if(typeChecking.contains(user)){
//                        DetailProfileView.profileType.setText("This is normal user Profile");
//
//                        DetailProfileView.firstName.setText(userRecord.get(0));
//                        DetailProfileView.firstName.setTextColor(getResources().getColor(R.color.normalUserColor));
//
//                        DetailProfileView.lastName.setText(userRecord.get(1));
//                        DetailProfileView.lastName.setTextColor(getResources().getColor(R.color.normalUserColor));
//
//                        DetailProfileView.email.setText(userRecord.get(2));
//                        DetailProfileView.email.setTextColor(getResources().getColor(R.color.normalUserColor));
//
//                        DetailProfileView.usertype.setText(userRecord.get(3));
//                        DetailProfileView.usertype.setTextColor(getResources().getColor(R.color.normalUserColor));
//                    }
               }

               catch (Exception e) {
                   Toast.makeText(getApplicationContext(), "check Username,password you entered!!!!!", Toast.LENGTH_SHORT).show();
                   e.printStackTrace();
               }

            }

        });






    }
}
