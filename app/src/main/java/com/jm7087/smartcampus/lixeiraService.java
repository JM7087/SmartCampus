package com.jm7087.smartcampus;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by JM7087-Notbook on 28/09/2017.
 */

public interface lixeiraService {
    @GET("/lixeira/")
    public Call<response> lixeira();
}
