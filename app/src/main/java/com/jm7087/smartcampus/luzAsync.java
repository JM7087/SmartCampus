package com.jm7087.smartcampus;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by JM7087-Notbook on 25/09/2017.
 */

public class luzAsync extends AsyncTask<String, Void, response> {
    private Context context;

    public luzAsync.onResponseRetrofitListnner listnner;


    public luzAsync(Context context, luzAsync.onResponseRetrofitListnner listnner) {
        this.context = context;
        this.listnner = listnner;
    }

    @Override
    protected response doInBackground(String... params) {

        return setDadosLuz(params[0]);
    }

    private response setDadosLuz(String ligadorDesligarLuz ){
        try {
            Call<response> thingsService = null;

            final luzService services = createServiceRetrofit();
            if(services != null) {
                thingsService = services.setDadosLuz(ligadorDesligarLuz);
                response response = (com.jm7087.smartcampus.response) thingsService.execute().body();

                return response;
            }
            return null;
        }catch (Exception e){
            Log.i("EXCEÇÃO----------------", e.getMessage());
            return null;
        }
    }
    private luzService createServiceRetrofit(){
        try {
            String baseUrl = URL.URLPATH;

            Gson gsonConverter = new GsonBuilder().registerTypeAdapter(response.class, new responseDeserializer())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                    .build();

            return retrofit.create(luzService.class);
        }catch (Exception e){
            return null;
        }
    }



    public interface onResponseRetrofitListnner{
        public void responseThings(response response);
    }

}
