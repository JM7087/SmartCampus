package com.jm7087.smartcampus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class energia extends AppCompatActivity {
    TextView viewEnergia;
    String mostraEnergia;

    public static int atualizarServidorOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energia);

        getDadosEnergia();

        atualizarServidorEnergia();

        atualizarServidorOnOff = 1;

        viewEnergia = (TextView) findViewById(R.id.textViewRecebeDadosDeEnegia);
    }

    public void atualizarServidorEnergia(){
        Thread threadTempo = new Thread(){
            @Override
            public void run() {
                while (atualizarServidorOnOff == 1) {
                    getDadosEnergia();
                    try {
                        this.sleep(8000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
        threadTempo.start();

    }


    private boolean getDadosEnergia(){

        energiaAsync sync = new energiaAsync(this, new energiaAsync.onResponseRetrofitListnner() {
            @Override
            public void responseThings(response response) {

                Toast.makeText(getApplicationContext(), "Atualizando ...", Toast.LENGTH_SHORT).show();

               mostraEnergia = response.response;

                viewEnergia.setText(mostraEnergia);

            }
        });
        sync.execute();
        return false;
    }
}
