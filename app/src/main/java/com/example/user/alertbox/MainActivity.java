package com.example.user.alertbox;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    EditText name,mail,pswd;
    Button bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bttn = findViewById(R.id.bttn);
        name =findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        pswd = findViewById(R.id.pswd);

        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //checking required field

                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Field is  empty");
                    return;
                }

                if(TextUtils.isEmpty(mail.getText().toString())){
                    mail.setError("Field is empty");
                    return;
                }

                if(TextUtils.isEmpty(pswd.getText().toString())){
                    pswd.setError("Field is empty");
                    return;
                }

                //alert box


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Submit Conformation");
                builder.setMessage("Are you sure?");
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "yes,confermed", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

            }
        });
    }
}