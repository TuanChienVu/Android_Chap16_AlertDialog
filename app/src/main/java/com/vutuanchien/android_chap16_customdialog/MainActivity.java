package com.vutuanchien.android_chap16_customdialog;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowDialog;
    Button btnSave;
    EditText edPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent(this, CountrycodeActivity.class);
        btnShowDialog = (Button) findViewById(R.id.btnCountryCode);
        edPhoneNo = (EditText) findViewById(R.id.edPhoneNo);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, 1);
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Your Phone No:" + edPhoneNo.getText(), Toast.LENGTH_SHORT).show();
                edPhoneNo.setText("");
                edPhoneNo.requestFocus();

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String countryCode = data.getStringExtra(CountrycodeActivity.RESULT_CONTRYCODE);
            edPhoneNo.setText("+" + countryCode);
            btnSave.setVisibility(View.VISIBLE);
            Toast.makeText(this, "You selected countrycode: " + countryCode, Toast.LENGTH_LONG).show();
        }
    }
}
