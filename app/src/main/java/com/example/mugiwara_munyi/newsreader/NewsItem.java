package com.example.mugiwara_munyi.newsreader;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This class represents a NewsItem.
 *
 * @author Jonathan Ngondi Munyi
 *
 */
public class NewsItem {

    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;

    /**
     * Method for getting the article's source.
     *
     * @return source
     */
    public Source getSource() {
        return source;
    }

    /**
     * @param source the article's source.
     */
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * Method for getting the article's author.
     *
     * @return author
     */

    public String getAuthor() {
        return author;
    }

    /**
     * @param author the article's author.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Method for getting the article's title.
     *
     * @return title
     */

    public String getTitle() {
        return title;
    }

    /**
     * @param title the article's title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Method for getting the article's description.
     *
     * @return description
     */

    public String getDescription() {
        return description;
    }

    /**
     * @param description the article's description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Method for getting the article's url.
     *
     * @return url
     */

    public String getUrl() {
        return url;
    }

    /**
     * @param url the article's url.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Method for getting the article's image url.
     *
     * @return urlToImage
     */

    public String getUrlToImage() {
        return urlToImage;
    }

    /**
     * @param urlToImage the article's Image url.
     */
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    /**
     * Method for getting the article's publishing date.
     *
     * @return publishedAt
     */
    public String getPublishedAt() {
        return publishedAt;
    }

    /**
     * @param publishedAt the article's date of Publishing.
     */
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

}

