package com.example.mugiwara_munyi.newsreader;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**Represents the source from which the Article came.
 *@author Jonathan Ngondi Munyi
 */
public class Source {


    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * Getter for returning source id.
     * @return id
     */

    public Object getId() {
        return id;
    }

    /**
     *
     * @param id the source's id.
     */

    public void setId(Object id) {
        this.id = id;
    }

    /**
     * Getter for returning source name.
     * @return name
     */


    public String getName() {
        return name;
    }

    /**
     *
     * @param name the source's name.
     */

    public void setName(String name) {
        this.name = name;
    }
}
