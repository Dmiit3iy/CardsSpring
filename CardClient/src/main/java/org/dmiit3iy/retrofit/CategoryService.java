package org.dmiit3iy.retrofit;

import org.dmiit3iy.dto.ResponseResult;
import org.dmiit3iy.model.Category;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CategoryService {
    @GET(".")
    Call<ResponseResult<List<Category>>> getAll();

    @GET("{id}")
    Call<ResponseResult<Category>> get(@Path("id") long id);

    @POST("{idUser}")
    Call<ResponseResult<Category>> post(@Path("idUser") long idUser, @Body Category category);

    @GET("user/{idUser}")
    Call<ResponseResult<List<Category>>> getByUser(@Path("idUser") long idUser);

    @PUT(".")
    Call<ResponseResult<Category>> put(@Body Category category);

    @DELETE("{id}")
    Call<ResponseResult<Category>> delete(@Path("id") long id);


}
