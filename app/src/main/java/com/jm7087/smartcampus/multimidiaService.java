package com.jm7087.smartcampus;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by JM7087-Notbook on 25/09/2017.
 */

public interface multimidiaService {
    @GET("/projetorPersiana/projetor={projetor}&persiana={persiana}")
    public Call<response> setDadosMultimidia(@Path("projetor") String projetor, @Path("persiana") String persiana);

}
