package test.roman.maginetest.rest_api;

/**
 * Created by Roman on 2016-10-23.
 */

/**
 * container for URL's that we us to fetch data
 */
public interface RestApi {
    String BASE_URL = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample";
    /** Suffix which point to JSON with list of videos with description use witch {@link RestApi#BASE_URL}**/
    String VIDEOS_LIST_SUFFIX = "/videos-enhanced-c.json";
    /** Use this to fetch JSON with videos list **/
    String MOVIES_LIST_URL = BASE_URL + VIDEOS_LIST_SUFFIX;
    /** URL with placeholder for getting video file **/
    String MOVIE_IMAGE_URL = BASE_URL + "/%s";
}
