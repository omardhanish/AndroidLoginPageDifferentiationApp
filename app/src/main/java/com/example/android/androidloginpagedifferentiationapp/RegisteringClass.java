package com.example.android.androidloginpagedifferentiationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by omar on 24-01-2017.
 */
public class RegisteringClass  extends Activity{
    DatabaseHelperConnector dConnector = new DatabaseHelperConnector(this);
    GetterSetter form = new GetterSetter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registering_layout);

         final EditText firstName = (EditText) findViewById(R.id.firstnamee);
         final EditText lastName = (EditText) findViewById(R.id.lastnamee);
         final EditText email = (EditText) findViewById(R.id.emaile);
         final EditText usertype = (EditText) findViewById(R.id.usertypee);
         final EditText username = (EditText) findViewById(R.id.usernamee);
         final EditText password = (EditText) findViewById(R.id.passe);

        Button submit = (Button) findViewById(R.id.submitee);



        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                form.setFirstName(firstName.getEditableText().toString());
                form.setLastName(lastName.getEditableText().toString());
                form.setEmail(email.getEditableText().toString());
                form.setUsertype(usertype.getEditableText().toString());
                form.setUsername(username.getEditableText().toString());
                form.setPassword(password.getEditableText().toString());
                dConnector.addRecord(form.getFirstName(), form.getLastName(), form.getEmail(), form.getUsertype(), form.getUsername(), form.getPassword());
                Toast.makeText(getApplicationContext(), "Record successfully Added!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisteringClass.this , MainActivity.class);
                startActivity(intent);
            }

        });


    }
}
