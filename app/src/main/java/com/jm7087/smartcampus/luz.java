package com.jm7087.smartcampus;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class luz extends AppCompatActivity {

    ImageView imageViewLuz;

    int ligadorDesligarLuz = 0;

    MediaPlayer somLuz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        somLuz = MediaPlayer.create(luz.this,R.raw.somonoff);

        imageViewLuz = (ImageView) findViewById(R.id.imageViewLuz);

    }

    public void luzOnOFF (View view) {

        somLuz.start();

        if (ligadorDesligarLuz == 0) {
            imageViewLuz.setImageResource(R.drawable.luz_ligada);

            ligadorDesligarLuz = 1;

            Toast.makeText(getApplicationContext(), "Luz Ligada", Toast.LENGTH_SHORT).show();
        } else {
            imageViewLuz.setImageResource(R.drawable.luz_desligada);
            ligadorDesligarLuz = 0;
            Toast.makeText(getApplicationContext(), "Luz Desligada", Toast.LENGTH_SHORT).show();

        }
        setaDadosLuz(String.valueOf(ligadorDesligarLuz));
    }


    private boolean setaDadosLuz(String ligadorDesligarLuz){

        luzAsync sync = new luzAsync(this, new luzAsync.onResponseRetrofitListnner() {
            @Override
            public void responseThings(response response) {
                if(!response.equals("OK")){
                    Toast.makeText(getApplicationContext(), "Ocorreu um erro ao se comunicar com o servidor", Toast.LENGTH_SHORT).show();

                }
            }
        });
        sync.execute(ligadorDesligarLuz);
        return false;
    }
}
