package com.vutuanchien.android_chap16_alertdialogedittext;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlertDialog = (Button) findViewById(R.id.btn_AlertDialog);

        btnAlertDialog.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                displayAlertDialog();
            }
        });
    }

    //show alertdialog custom
    public void displayAlertDialog() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.custom_alertdialog, null);
        final EditText edUsername = (EditText) alertLayout.findViewById(R.id.edUsername);
        final EditText edPassword = (EditText) alertLayout.findViewById(R.id.edPassword);
        final CheckBox cbShowPassword = (CheckBox) alertLayout.findViewById(R.id.cbShowPassword);

        cbShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    edPassword.setTransformationMethod(null);
                else
                    edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Login");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Login", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // code for matching password
                if (edUsername.getText().toString().equals("") || edPassword.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please, Enter your full info!", Toast.LENGTH_SHORT).show();
                } else {
                    String user = edUsername.getText().toString();
                    String pass = edPassword.getText().toString();
                    Toast.makeText(getBaseContext(), "Username: " + user + "\nPassword: " + pass, Toast.LENGTH_SHORT).show();
                }
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}
