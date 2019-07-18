package com.lco.cabbookkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class home extends AppCompatActivity {
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        WebView web =findViewById(R.id.web);
        web.loadUrl("https://github.com/khyati2598");
        web.setWebViewClient(new WebViewClient());

        FirebaseUser muser=FirebaseAuth.getInstance().getCurrentUser();
        String email=((FirebaseUser) muser).getEmail();
        Toast.makeText(this,email, Toast.LENGTH_SHORT).show();

    }
}
