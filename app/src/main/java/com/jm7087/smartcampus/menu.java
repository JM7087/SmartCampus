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

    }

    public void IrParaMultimidia (View view){
        Intent intentTelaMultimidia = new Intent(getApplicationContext(),multimidia.class);
        startActivity(intentTelaMultimidia);
        lixeira.atualizaServidorOnOff = 0;

    }

    public void IrParaLixeira (View view){
        Intent intentTelaLixeira = new Intent(getApplicationContext(),lixeira.class);
        startActivity(intentTelaLixeira);
    }

}
