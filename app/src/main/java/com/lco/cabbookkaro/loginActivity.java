package com.lco.cabbookkaro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class loginActivity extends AppCompatActivity {
    EditText e,p;
    TextView fp,nt;
    Button lg;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fp=findViewById(R.id.btn_reset_password);
        lg=findViewById(R.id.lgin);
        e=findViewById(R.id.ed1);
        p=findViewById(R.id.ed2);
        nt=findViewById(R.id.sign_up_button);

        nt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signupActivty.class));
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this,resetpassword.class));
            }
        });

        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e.getText().toString();
                String password=p.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Authentication Successful",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(loginActivity.this,home.class));
                            finish();
                        }else{
                            Toast.makeText(loginActivity.this, "Authentication Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}
