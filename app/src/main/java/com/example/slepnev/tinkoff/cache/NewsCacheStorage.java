package com.example.slepnev.tinkoff.cache;

import com.example.slepnev.tinkoff.model.dto.NewsDTO;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by slepnev on 13.03.16.
 */
public class NewsCacheStorage extends CacheStorage<List<NewsDTO>> {

    public static final String FILE_NAME = "news";

    public NewsCacheStorage() {
        super(new TypeToken<List<NewsDTO>>() {}.getType());
    }

    @Override
    protected String getFileName() {
        return FILE_NAME;
    }
}
