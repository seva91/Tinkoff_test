package com.example.slepnev.tinkoff.network;

import android.util.Log;

import com.example.slepnev.tinkoff.model.dto.NewsContentDTO;
import com.example.slepnev.tinkoff.model.dto.NewsDTO;
import com.example.slepnev.tinkoff.model.dto.ResponseServer;
import com.example.slepnev.tinkoff.network.exceptions.InteractionException;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by slepnev on 12.03.16.
 * the responsibility of this class is the interaction with the api of server
 */
public class Server {

    private RestAdapter.Builder mBuilder;
    private ApiServer mApiServer;

    public Server(String url) {

        mBuilder = new RestAdapter.Builder()
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(new GsonConverter(new Gson()))
                .setEndpoint(url);

        RestAdapter adapter = mBuilder.build();

        mApiServer = adapter.create(ApiServer.class);
    }

    public List<NewsDTO> getNews() throws InteractionException {
        ResponseServer<List<NewsDTO>> response = mApiServer.getNews();
        return getResultOrThrow(response);
    }

    public NewsContentDTO getNewsContent(int id) throws InteractionException {
        ResponseServer<NewsContentDTO> response = mApiServer.getNewsContent(id);
        return getResultOrThrow(response);
    }

    private <ResultType> ResultType getResultOrThrow(ResponseServer<ResultType> response) throws InteractionException
    {
        if (!"OK".equals(response.getResultCode()))
            throw new InteractionException(response.getResultCode());

        return response.getPayload();
    }

    private interface ApiServer {

        String QUERY_NEWS_CONTENT_ID = "id";

        @GET("/news")
        ResponseServer<List<NewsDTO>> getNews();

        @GET("/news_content")
        ResponseServer<NewsContentDTO> getNewsContent(@Query(QUERY_NEWS_CONTENT_ID) int id);
    }

}
