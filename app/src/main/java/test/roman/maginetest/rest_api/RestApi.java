package test.roman.maginetest.rest_api;

/**
 * Created by Roman on 2016-10-23.
 */

public interface RestApi {
    String BASE_URL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample";
    String VIDEOS_LIST_SUFFIX = "/videos-enhanced-c.json";
    String MOVIES_LIST_URL = BASE_URL + VIDEOS_LIST_SUFFIX;
    String MOVIE_IMAGE_URL = BASE_URL + "/%s";
}
