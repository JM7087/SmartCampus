package com.jm7087.smartcampus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ip extends AppCompatActivity {

    EditText ipDigitado;

    TextView ipAtual;

    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);

        ipDigitado = (EditText) findViewById(R.id.editTextIp);
        ipAtual = (TextView) findViewById(R.id.textViewIpAtual);

        ipAtual.setText("O seu IP é: "+ URL.URLPATH);

    }

    public void ipDoServidor (View view){
        ip = "http://"+ipDigitado.getText().toString()+":7087";
        URL.URLPATH = ip;
        Toast.makeText(getApplicationContext(),"O seu IP é: "+ URL.URLPATH, Toast.LENGTH_SHORT).show();

        ipAtual.setText("O seu IP é: "+ URL.URLPATH);
    }
}
