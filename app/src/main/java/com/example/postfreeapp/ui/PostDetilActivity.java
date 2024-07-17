package com.example.postfreeapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.postfreeapp.R;

public class PostDetilActivity extends AppCompatActivity {
    private TextView title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post_deail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        title =findViewById(R.id.tvPostTitle);
        body =findViewById(R.id.tvPostBody);
        Intent intent =getIntent();
        if(intent.getStringExtra("TITLE") !=null){
            title.setText(intent.getStringExtra("TITLE"));
        }
        if (intent.getStringExtra("BODY") !=null){
            body.setText(intent.getStringExtra("BODY"));
        }


    }
}