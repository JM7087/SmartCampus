package com.jm7087.smartcampus;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class arCondicionado extends AppCompatActivity {
    TextView viewTempo;
    int valorTempo = 0;
    String mostraTempo;
    int tempoMaximo = 30;
    int tempoMinimo = 16;
    int autoOnOff = 0;
    int arOnOff = 0;

    int egg = 13;
    TextView eggView;
    String cotEgg;

    MediaPlayer somDePiMaisMenos;
    MediaPlayer somOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_condicionado);

        viewTempo = (TextView) findViewById(R.id.textViewTempo);
        eggView = (TextView) findViewById(R.id.textVieweEgg);

        somDePiMaisMenos = MediaPlayer.create(arCondicionado.this,R.raw.somdepi);
        somOnOff = MediaPlayer.create(arCondicionado.this,R.raw.somonoff);

    }

    public void TempoMais (View view) {

        if (valorTempo == 00){
            //continua
        }else {

            if (valorTempo >= tempoMaximo) {
                //continua
                Toast.makeText(getApplicationContext(), "Temperatura Maxima", Toast.LENGTH_SHORT).show();

            } else {

                somDePiMaisMenos.start();

                valorTempo = valorTempo + 1;

                mostraTempo = Integer.toString(valorTempo);

                viewTempo.setText(mostraTempo);
                setaDadosAr(String.valueOf(arOnOff), mostraTempo.toString(), String.valueOf(autoOnOff));
            }
        }

    }

    public void TempoMenos (View view) {

        if (arOnOff == 0){
            //continua
        }else {

            if (valorTempo <= tempoMinimo) {
                //continua
                Toast.makeText(getApplicationContext(), "Temperatura Minima", Toast.LENGTH_SHORT).show();
            } else {

                somDePiMaisMenos.start();

                valorTempo = valorTempo - 1;

                mostraTempo = Integer.toString(valorTempo);

                viewTempo.setText(mostraTempo);
                setaDadosAr(String.valueOf(arOnOff), mostraTempo.toString(), String.valueOf(autoOnOff));

            }
        }

    }

    public void onOff (View view){

        somOnOff.start();

        if (valorTempo >= tempoMinimo) {
            valorTempo = 0;

            arOnOff = 0;

            mostraTempo = "- -";

            viewTempo.setText(mostraTempo);

        }else {
            valorTempo = 23;

            arOnOff = 1;

            mostraTempo = Integer.toString(valorTempo);

            viewTempo.setText(mostraTempo);
        }

        setaDadosAr(String.valueOf(arOnOff), mostraTempo.toString(), String.valueOf(autoOnOff));

    }

    public void automatico (View view){

        if (arOnOff == 0){
            //continua
            egg = egg - 1;
            cotEgg = Integer.toString(egg);

            Toast.makeText(getApplicationContext(),cotEgg, Toast.LENGTH_SHORT).show();
            if (egg <= 1){
                eggView.setText("WWW.JM7087.COM");
            }

        }else {

            if (autoOnOff == 1){

                somDePiMaisMenos.start();

                autoOnOff = 0;

                mostraTempo = Integer.toString(valorTempo);

                viewTempo.setText(mostraTempo);

                setaDadosAr(String.valueOf(arOnOff), mostraTempo.toString(), String.valueOf(autoOnOff));


            }else {

                somDePiMaisMenos.start();

                autoOnOff = 1;

                viewTempo.setText("AUTO");

                setaDadosAr(String.valueOf(arOnOff), mostraTempo.toString(), String.valueOf(autoOnOff));

            }
        }

    }

    private boolean setaDadosAr(String ligado, String tempo, String auto){

        arCondicionadoAsync sync = new arCondicionadoAsync(arCondicionado.this, new arCondicionadoAsync.onResponseRetrofitListnner() {
            @Override
            public void responseThings(response response) {
                Toast.makeText(getApplicationContext(), "Conectado", Toast.LENGTH_SHORT).show();
            }
        });
        sync.execute(ligado, tempo, auto);
        return false;
    }
}