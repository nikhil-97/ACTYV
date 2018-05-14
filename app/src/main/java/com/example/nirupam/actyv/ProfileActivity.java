package com.example.nirupam.actyv;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView welcome;
    //    private String testVar = getIntent().getStringExtra("RANDOM_NUMBER");
    private FirebaseAuth firebaseAuth;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        //checking for user login
        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
        welcome = (TextView) findViewById(R.id.welcTV);
        button = (Button) findViewById(R.id.logout_button);
        button.setOnClickListener(this);
        // FirebaseUser user = firebaseAuth.getCurrentUser();

        //set welcome to the testVar

        welcome.setText("Welcome user  "  );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public void onClick(View view) {
        if(view == button){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
