package test.roman.maginetest.movies_list.loaders;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import test.roman.maginetest.movies_list.models.RootObject;
import test.roman.maginetest.rest_api.RestApi;

/**
 * Created by Roman on 2016-10-23.
 */

public class MoviesListLoader extends AsyncTaskLoader<RootObject> {

    private RootObject rootObject;

    public MoviesListLoader(Context context) {
        super(context);
    }

    @Override
    public RootObject loadInBackground() {
        RootObject rootObject = null;
        try {
            Gson gson = new Gson();
            final String json = loadJson(RestApi.MOVIES_LIST_URL);
            rootObject = gson.fromJson(json, RootObject.class);
        }catch (IOException ignored){}
        return rootObject;
    }

    @Override
    protected void onStartLoading() {
        if (takeContentChanged() || rootObject == null){
            forceLoad();
        }else {
            deliverResult(rootObject);
        }
    }

    private String loadJson(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
