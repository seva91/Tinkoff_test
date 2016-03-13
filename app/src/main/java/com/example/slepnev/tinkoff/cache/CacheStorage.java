package com.example.slepnev.tinkoff.cache;

import com.example.slepnev.tinkoff.TinkoffApplication;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;

/**
 * Created by slepnev on 13.03.16.
 */
public abstract class CacheStorage <T> {

    protected static final File sDir = TinkoffApplication.getContext().getCacheDir();

    protected Type mType;

    public CacheStorage(Type type) {
        this.mType = type;
    }

    public void deleteStorage()
    {
        getFileCacheStorage().delete();
    }

    public T getObject() {
        File file = getFileCacheStorage();

        if (file.exists()) {
            return new Gson().fromJson(readStringFromFile(file), mType);
        } else {
            return null;
        }
    }

    public  void saveObject(T object) {
        File file = getFileCacheStorage();
        writeStringToFile(new Gson().toJson(object), file);
    }

    abstract protected String getFileName();

    protected File getFileCacheStorage() {
        return new File(sDir, getFileName());
    }

    private String readStringFromFile(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void writeStringToFile(String string, File file) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(string);
            bw.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
