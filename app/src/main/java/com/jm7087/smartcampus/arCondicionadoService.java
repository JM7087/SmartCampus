package com.jm7087.smartcampus;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JM7087-Notbook on 25/09/2017.
 */

public interface arCondicionadoService {
    @GET("/arcondicionado/ligado={ligado}&tempo={tempo}&auto={auto}")
    public Call<response> setDadosAr(@Path("ligado") String ligado, @Path("tempo") String tempo, @Path("auto") String auto);

}
