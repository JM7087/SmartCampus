package com.jm7087.smartcampus;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class lixeira extends AppCompatActivity {

    TextView viewPorcentagem;
    String mostraPorcentagem;

    int lixeiraFull;
    MediaPlayer somDeLixeira;

    public static int atualizaServidorOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lixeira);

        atualizarServidorDePorcentagemDaLixeira();

        atualizaServidorOnOff = 1;

        viewPorcentagem = (TextView) findViewById(R.id.textViewPorcentagem);

        somDeLixeira = MediaPlayer.create(lixeira.this,R.raw.somlixeirafull);

    }

    public void atualizarServidorDePorcentagemDaLixeira(){
        Thread threadTempo = new Thread(){
            @Override
            public void run() {
                while (atualizaServidorOnOff == 1) {
                        getDadosLixeira();
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

    private boolean getDadosLixeira(){

        lixeiraAsync sync = new lixeiraAsync(this, new lixeiraAsync.onResponseRetrofitListnner() {
            @Override
            public void responseThings(response response) {

               Toast.makeText(getApplicationContext(), "Atualizando ...", Toast.LENGTH_SHORT).show();

               mostraPorcentagem = response.response;

               viewPorcentagem.setText(mostraPorcentagem+"%");

                lixeiraFull = Integer.parseInt(mostraPorcentagem);
                if (lixeiraFull >= 100){
                    somDeLixeira.start();
                }

            }
        });
        sync.execute();
        return false;
    }
}
