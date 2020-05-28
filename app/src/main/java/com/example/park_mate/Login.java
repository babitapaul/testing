package com.example.park_mate;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button button,button1;
    TextView back;
    ProgressBar pgsBar;
    TextView forgot;
    EditText emailid,password;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       pgsBar = (ProgressBar) findViewById(R.id.pbloading);
        back=(TextView)findViewById(R.id.back);
        button1=(Button) findViewById(R.id.button1);
        forgot =(TextView)findViewById(R.id.forgot);
        button =(Button)findViewById(R.id.button2);
        emailid=(EditText)findViewById(R.id.login_emailid);
        password=(EditText)findViewById(R.id.login_password);
        pgsBar.setVisibility(View.GONE);
        firebaseAuth=FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Login.this,NewUser.class);
                startActivity(intent);
            }
        });




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pgsBar.setVisibility(View.VISIBLE);
                String email, pass;
                email = emailid.getText().toString();
                pass= password.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please Enter Emailid!", Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                    pgsBar.setVisibility(View.GONE);
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast toast = Toast.makeText(getApplicationContext(),  "Please Enter Password!", Toast.LENGTH_SHORT);
                    toast.setMargin(50,50);
                    toast.show();
                    pgsBar.setVisibility(View.GONE);
                    return;
                }



            }
        });

    }
}
