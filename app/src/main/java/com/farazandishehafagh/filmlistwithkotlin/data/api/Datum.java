
package com.farazandishehafagh.filmlistwithkotlin.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Paniz Alipour 99.09.05
 */
public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("poster")
    @Expose
    private String poster;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("images")
    @Expose
    private List<String> images = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Datum(Integer id, String title, String poster, List<String> genres, List<String> images) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.genres = genres;
        this.images = images;
    }
}
