package com.example.slepnev.tinkoff.cache;

import com.example.slepnev.tinkoff.model.dto.NewsContentDTO;

import org.joda.time.LocalDate;

import java.io.File;
import java.lang.reflect.Type;

/**
 * Created by slepnev on 13.03.16.
 */
public class NewsContentCacheStorage  extends CacheStorage<NewsContentDTO> {

    public static final String FILE_NAME = "news_content";

    private int mId;

    public static void deleteAllFiles() {
        for(File file : sDir.listFiles())
        {
            String fileName = file.getName();

            if (fileName.contains(FILE_NAME)) {
                file.delete();
            }
        }
    }

    public NewsContentCacheStorage(int id) {
        super(NewsContentDTO.class);
        mId = id;
    }

    @Override
    protected String getFileName() {
        return FILE_NAME + mId;
    }
}
