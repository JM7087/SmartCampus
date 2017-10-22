package com.jm7087.smartcampus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }


    public void IrParaArCondicionado (View view){
        Intent intentTelaArCondicionado = new Intent(getApplicationContext(),arCondicionado.class);
        startActivity(intentTelaArCondicionado);
        lixeira.atualizaServidorOnOff = 0;
        energia.atualizarServidorOnOff = 0;

    }

    public void IrParaLuz (View view){
        Intent intentTelaLuz = new Intent(getApplicationContext(),luz.class);
        startActivity(intentTelaLuz);
        lixeira.atualizaServidorOnOff = 0;
        energia.atualizarServidorOnOff = 0;

    }

    public void IrParaLixeira (View view){
        Intent intentTelaLixeira = new Intent(getApplicationContext(),lixeira.class);
        startActivity(intentTelaLixeira);
        energia.atualizarServidorOnOff = 0;
    }

    public void IrParaEnergia (View view){
        Intent intentTelaEnergia = new Intent(getApplicationContext(),energia.class);
        startActivity(intentTelaEnergia);
        lixeira.atualizaServidorOnOff = 0;

    }

    public void IrParaIp (View view){
        Intent intentTelaIp = new Intent(getApplicationContext(),ip.class);
        startActivity(intentTelaIp);
        lixeira.atualizaServidorOnOff = 0;
        energia.atualizarServidorOnOff = 0;

    }

}
