package org.dmiit3iy.retrofit;

import org.dmiit3iy.dto.ResponseResult;
import org.dmiit3iy.model.Card;
import org.dmiit3iy.model.Category;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CardService {

    @GET(".")
    Call<ResponseResult<List<Card>>> getAll();

    @GET("{id}")
    Call<ResponseResult<Card>> get(@Path("id") long id);

    @POST("{idCategory}")
    Call<ResponseResult<Card>> post(@Path("idCategory") long idUser, @Body Card card);

    @GET("card/{idCategory}")
    Call<ResponseResult<List<Card>>> getByIdCategory(@Path("idCategory") long idCategory);

    @GET("user/{idUser}")
    Call<ResponseResult<List<Card>>> getByIdUser(@Path("idUser") long idUser);

    @PUT(".")
    Call<ResponseResult<Card>> put(@Body Card card);

    @DELETE("{id}")
    Call<ResponseResult<Card>> delete(@Path("id") long id);


}
