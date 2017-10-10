package com.jm7087.smartcampus;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by JM7087-Notbook on 10/10/2017.
 */

public class energiaAsync extends AsyncTask <String, Void, response>{
    private Context context;

    public energiaAsync.onResponseRetrofitListnner listnner;


    public energiaAsync(Context context, energiaAsync.onResponseRetrofitListnner listnner) {
        this.context = context;
        this.listnner = listnner;
    }


    @Override
    protected response doInBackground(String... params) {

        return getDadosEnegia();
    }

    private response getDadosEnegia(){
        try {
            Call<response> thingsService = null;

            final energiaService services = createServiceRetrofit();
            if(services != null) {
                thingsService = services.energia();
                response thingsResponse = (response) thingsService.execute().body();
                Log.i("vvvvvvvvvvvvv",thingsResponse.response);
                List<response> listThings = new ArrayList<>();

                listThings.add(thingsResponse);
                return thingsResponse;
            }
            return null;
        }catch (Exception e){
            Log.i("EXCEÇÃO----------------", e.getMessage());
            return null;
        }
    }

    private energiaService createServiceRetrofit(){
        try {
            String baseUrl = URL.URLPATH;

            Gson gsonConverter = new GsonBuilder().registerTypeAdapter(response.class, new responseDeserializer())
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gsonConverter))
                    .build();

            return retrofit.create(energiaService.class);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute (response trings){
        listnner.responseThings(trings);
    }

    public interface onResponseRetrofitListnner{
        public void responseThings(response response);
    }
}
