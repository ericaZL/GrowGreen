package com.example.shivani.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText editUsername = (EditText) findViewById(R.id.editUsername);
        final EditText editPassword = (EditText)findViewById(R.id.editPassword);
        final Button login = (Button)findViewById(R.id.login);
        final TextView registerLink = (TextView) findViewById(R.id.textRegister);
        registerLink.setOnClickListener(new View.OnClickListener()
    {
            @Override
                    public void onClick(View v)
        {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
        }
    });

    }
}
