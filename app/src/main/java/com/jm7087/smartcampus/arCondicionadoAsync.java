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

public class arCondicionadoAsync extends AsyncTask<String, Void, response> {
    private Context context;

    public arCondicionadoAsync.onResponseRetrofitListnner listnner;


    public arCondicionadoAsync(Context context, arCondicionadoAsync.onResponseRetrofitListnner listnner) {
        this.context = context;
        this.listnner = listnner;
    }

    @Override
    protected response doInBackground(String... params) {

        return setDadosAr(params[0], params[1], params[2]);
    }

    private response setDadosAr(String ligado, String tempo, String auto ){
        try {
            Call<response> thingsService = null;

            final arCondicionadoService services = createServiceRetrofit();
            if(services != null) {
                thingsService = services.setDadosAr(ligado, tempo, auto);
                response response = (com.jm7087.smartcampus.response) thingsService.execute().body();

                return response;
            }
            return null;
        }catch (Exception e){
            Log.i("EXCEÇÃO----------------", e.getMessage());
            return null;
        }
    }
    private arCondicionadoService createServiceRetrofit(){
        try {
            String baseUrl = URL.URLPATH;

            Gson gsonConverter = new GsonBuilder().registerTypeAdapter(response.class, new responseDeserializer())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                    .build();

            return retrofit.create(arCondicionadoService.class);
        }catch (Exception e){
            return null;
        }
    }



    public interface onResponseRetrofitListnner{
        public void responseThings(response response);
    }

}
