package com.example.slepnev.tinkoff.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.slepnev.tinkoff.cache.CacheStorage;
import com.example.slepnev.tinkoff.network.Server;
import com.example.slepnev.tinkoff.network.exceptions.InteractionException;
import com.example.slepnev.tinkoff.other.Const;

/**
 * Created by slepnev on 12.03.16.
 */
public abstract class ServerLoader<ResultType> extends AsyncTaskLoader<ServerLoader.WrappedResponse<ResultType>> {

    public static class WrappedResponse<Type> {
        public Type result;
        public InteractionException error;
    }

    protected Server mServer;

    public ServerLoader(Context context) {
        super(context);
        mServer = new Server(Const.URL);
    }

    @Override
    public WrappedResponse<ResultType> loadInBackground() {
        WrappedResponse<ResultType> result = new WrappedResponse<>();

        result.result = getCacheStorage().getObject();

        if (result.result == null) {
            try {
                result.result = requestServer();
            } catch (InteractionException e) {
                result.error = e;
            }
        }

        return result;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        super.onReset();
    }

    abstract protected CacheStorage<ResultType> getCacheStorage();

    abstract protected ResultType requestServer() throws InteractionException;
}
