package test.roman.maginetest.movies_list.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("sources")
    private List<String> sources = new ArrayList<String>();
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("image-480x270")
    private String image480x270;
    @SerializedName("image-780x1200")
    private String image780x1200;
    @SerializedName("title")
    private String title;
    @SerializedName("studio")
    private String studio;

    /**
     *
     * @return
     * The subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     *
     * @param subtitle
     * The subtitle
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     *
     * @return
     * The sources
     */
    public List<String> getSources() {
        return sources;
    }

    /**
     *
     * @param sources
     * The sources
     */
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    /**
     *
     * @return
     * The thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     *
     * @param thumb
     * The thumb
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     *
     * @return
     * The image480x270
     */
    public String getImage480x270() {
        return image480x270;
    }

    /**
     *
     * @param image480x270
     * The image-480x270
     */
    public void setImage480x270(String image480x270) {
        this.image480x270 = image480x270;
    }

    /**
     *
     * @return
     * The image780x1200
     */
    public String getImage780x1200() {
        return image780x1200;
    }

    /**
     *
     * @param image780x1200
     * The image-780x1200
     */
    public void setImage780x1200(String image780x1200) {
        this.image780x1200 = image780x1200;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     *
     * @param studio
     * The studio
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

}

