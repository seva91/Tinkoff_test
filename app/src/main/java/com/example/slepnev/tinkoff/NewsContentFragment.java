package com.example.slepnev.tinkoff;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.slepnev.tinkoff.cache.CacheStorage;
import com.example.slepnev.tinkoff.cache.NewsContentCacheStorage;
import com.example.slepnev.tinkoff.loaders.ServerLoader;
import com.example.slepnev.tinkoff.model.dto.NewsContentDTO;
import com.example.slepnev.tinkoff.network.exceptions.InteractionException;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link NewsActivity}
 * in two-pane mode (on tablets) or a {@link NewsContentActivity}
 * on handsets.
 */
public class NewsContentFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private NewsContentDTO mNewsContent;

    private TextView mNewsContentTextView;
    private TextView mNewsTitleTextView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NewsContentFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            final int newsId = getArguments().getInt(ARG_ITEM_ID);

            getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<ServerLoader.WrappedResponse<NewsContentDTO>>() {

                @Override
                public Loader<ServerLoader.WrappedResponse<NewsContentDTO>> onCreateLoader(int id, Bundle args) {

                    ServerLoader<NewsContentDTO> loader = new ServerLoader<NewsContentDTO>(NewsContentFragment.this.getActivity()) {
                        @Override
                        protected CacheStorage<NewsContentDTO> getCacheStorage() {
                            return new NewsContentCacheStorage(newsId);
                        }

                        @Override
                        protected NewsContentDTO requestServer() throws InteractionException {
                            return mServer.getNewsContent(newsId);
                        }
                    };

                    return loader;
                }

                @Override
                public void onLoadFinished(Loader<ServerLoader.WrappedResponse<NewsContentDTO>> loader, ServerLoader.WrappedResponse<NewsContentDTO> data) {

                    if (data.error == null) {
                        mNewsContent = data.result;

                        mNewsTitleTextView.setText(mNewsContent.getTitle().getName());

                        mNewsContentTextView.setText(Html.fromHtml(mNewsContent.getContent()));

                        new NewsContentCacheStorage(mNewsContent.getTitle().getId()).saveObject(mNewsContent);

                    } else {
                        // TODO handle error
                    }


                }

                @Override
                public void onLoaderReset(Loader<ServerLoader.WrappedResponse<NewsContentDTO>> loader) {

                }
            });

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_content, container, false);

        mNewsContentTextView = (TextView) rootView.findViewById(R.id.item_detail);
        mNewsTitleTextView = (TextView) rootView.findViewById(R.id.news_title);

        return rootView;
    }
}
