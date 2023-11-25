package org.dmiit3iy.retrofit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import org.dmiit3iy.dto.ResponseResult;
import org.dmiit3iy.model.Category;
import org.dmiit3iy.model.User;
import org.dmiit3iy.util.Constants;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class CategoryRepository {
    private ObjectMapper objectMapper;
    private CategoryService service;

    public CategoryRepository() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.URL + "category/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper)).client(client).build();

        this.service = retrofit.create(CategoryService.class);
    }

    private <T> T getData(Response<ResponseResult<T>> execute) throws IOException {
        if (execute.code() != 200) {
            String message = objectMapper.readValue(execute.errorBody().string(),
                    new TypeReference<ResponseResult<T>>() {
                    }).getMessage();
            throw new IllegalArgumentException(message);
        }
        return execute.body().getData();
    }

    public Category post(long idUser, Category category) throws IOException {
        Response<ResponseResult<Category>> execute = this.service.post(idUser, category).execute();
        return getData(execute);
    }

    public List<Category> getAll() throws IOException {
        return service.getAll().execute().body().getData();
    }

    public List<Category> getByUserId(long userId) throws IOException {
        Response<ResponseResult<List<Category>>> execute = service.getByUser(userId).execute();
        return getData(execute);
    }

    public Category getByCategoryId(long categoryId) throws IOException {
        Response<ResponseResult<Category>> execute = service.get(categoryId).execute();
        return getData(execute);
    }
    public Category delete(long id) throws IOException {
        Response<ResponseResult<Category>> execute = service.delete(id).execute();
        return getData(execute);
    }

    public Category put(Category category) throws IOException {
        Response<ResponseResult<Category>> execute = this.service.put(category).execute();
        return getData(execute);
    }
}
