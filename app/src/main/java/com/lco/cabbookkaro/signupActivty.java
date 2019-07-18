package com.lco.cabbookkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupActivty extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button signUp;
    EditText e1,e2;
    ProgressDialog progressDialog;
    String Email,Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_activty);
        e1 =  findViewById(R.id.et1);
        e2 =  findViewById(R.id.et2);
        signUp =  findViewById(R.id.sgup);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email=e1.getText().toString().trim();
                Pass=e2.getText().toString().trim();

                RegisterUser(Email,Pass);

            }
        });

    }

    private void RegisterUser(String email, String Password) {

        mAuth.createUserWithEmailAndPassword(email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful())
                {
                    Toast.makeText(signupActivty.this, "Success", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(getApplicationContext(),home.class));
                }
                else
                {

                    Toast.makeText(signupActivty.this, "Error", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(signupActivty.this,home.class));
                }

                finish();
            }
        });
    }
}