package com.jm7087.smartcampus;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class multimidia extends AppCompatActivity {

    int projetorOnOff = 0;
    int persianaAbertaFechada  = 0;

    MediaPlayer somProjetor;
    MediaPlayer somPersiana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projetor_persiana);
        Toast.makeText(getApplicationContext(), "Conectado", Toast.LENGTH_SHORT).show();

        somProjetor = MediaPlayer.create(multimidia.this,R.raw.somprojetor);
        somPersiana = MediaPlayer.create(multimidia.this,R.raw.sompersiana);

    }

    public void Projetor (View view) {

        somProjetor.start();

        if (projetorOnOff == 0) {

            projetorOnOff = 1;
            Toast.makeText(getApplicationContext(), "Projetor Ligado", Toast.LENGTH_SHORT).show();
        } else {
            projetorOnOff = 0;
            Toast.makeText(getApplicationContext(), "Projetor Desligado", Toast.LENGTH_SHORT).show();

        }
        setaDadosMultimidia(String.valueOf(projetorOnOff), String.valueOf(persianaAbertaFechada));
    }

    public void Persiana (View view){

        somPersiana.start();

        if (persianaAbertaFechada == 0) {

            persianaAbertaFechada = 1;
            Toast.makeText(getApplicationContext(), "Persiana Aberta", Toast.LENGTH_SHORT).show();
        }else {
            persianaAbertaFechada = 0;
            Toast.makeText(getApplicationContext(), "Persiana Fechada", Toast.LENGTH_SHORT).show();

        }
        setaDadosMultimidia(String.valueOf(projetorOnOff), String.valueOf(persianaAbertaFechada));

    }

    private boolean setaDadosMultimidia(String projetor, String persiana){

        multimidiaAsync sync = new multimidiaAsync(this, new multimidiaAsync.onResponseRetrofitListnner() {
            @Override
            public void responseThings(response response) {
                if(!response.equals("OK")){
                    Toast.makeText(getApplicationContext(), "Ocorreu um erro ao se comunicar com o servidor", Toast.LENGTH_SHORT).show();

                }
            }
        });
        sync.execute(projetor, persiana);
        return false;
    }
}
