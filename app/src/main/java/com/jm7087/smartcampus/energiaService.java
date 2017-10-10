package com.jm7087.smartcampus;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by JM7087-Notbook on 10/10/2017.
 */

public interface energiaService {
    @GET("/energia/")
    public Call<response> energia();

}
