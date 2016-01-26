package com.sidiq.samplegeofire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtUsername;
    private Button btnSubmit;

    private SampleGeoFirePrefs prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsername = (EditText)findViewById(R.id.edt_username);
        btnSubmit = (Button)findViewById(R.id.btn_submit_username);
        btnSubmit.setOnClickListener(this);

        prefs = new SampleGeoFirePrefs(RegisterActivity.this);

        if (!prefs.getUsername().equals("")){
            toMainActivity();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_submit_username){
            String username = edtUsername.getText().toString().trim();
            if (username.equals("")){
                Toast.makeText(RegisterActivity.this, "Username tidak boleh kosong", Toast.LENGTH_LONG).show();
            }else{
                prefs.setUsername(username);

                toMainActivity();
            }
        }
    }

    private void toMainActivity() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
