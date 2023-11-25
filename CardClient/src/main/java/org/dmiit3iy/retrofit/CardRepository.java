package org.dmiit3iy.retrofit;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.OkHttpClient;
import org.dmiit3iy.dto.ResponseResult;
import org.dmiit3iy.model.Card;
import org.dmiit3iy.model.Category;
import org.dmiit3iy.util.Constants;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;

public class CardRepository {
    private ObjectMapper objectMapper;
    private CardService service;


    public CardRepository() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.URL + "card/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper)).client(client).build();

        this.service = retrofit.create(CardService.class);
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

    public Card post(long idCategory, Card card) throws IOException {
        Response<ResponseResult<Card>> execute = this.service.post(idCategory, card).execute();
        return getData(execute);
    }

    public List<Card> getAll() throws IOException {
        return service.getAll().execute().body().getData();
    }

    public Card getByCardId(long cardId) throws IOException {
        Response<ResponseResult<Card>> execute = service.get(cardId).execute();
        return getData(execute);
    }

    public List<Card> getByUserId(long userId) throws IOException {
        Response<ResponseResult<List<Card>>> execute = service.getByIdUser(userId).execute();
        return getData(execute);
    }

    public List<Card> getByCategoryId(long categoryId) throws IOException {
        Response<ResponseResult<List<Card>>> execute = service.getByIdCategory(categoryId).execute();
        return  getData(execute);
    }

    public Card delete(long id) throws IOException {
        Response<ResponseResult<Card>> execute = service.delete(id).execute();
        return getData(execute);
    }

    public Card put(Card card) throws IOException {
        Response<ResponseResult<Card>> execute = this.service.put(card).execute();
        return getData(execute);
    }


}
