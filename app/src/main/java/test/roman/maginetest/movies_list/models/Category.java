package test.roman.maginetest.movies_list.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    private String name;
    @SerializedName("videos")
    private List<Video> videos = new ArrayList<>();

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The videos
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     *
     * @param videos
     * The videos
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

}