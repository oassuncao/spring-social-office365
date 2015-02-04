package org.springframework.social.office365.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class FileSystemItem {
// ------------------------------ FIELDS ------------------------------

    @JsonProperty("Id")
    private String id;

    @JsonProperty("ETag")
    private String eTag;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Url")
    private String url;

    @JsonProperty("TimeLastModified")
    private String timeLastModified;

    @JsonProperty("CreatedBy")
    private User createdBy;

    @JsonProperty("TimeCreated")
    private String timeCreated;

    @JsonProperty("LastModifiedBy")
    private String lastModifiedBy;

    @JsonProperty("Size")
    private Long size;

// --------------------- GETTER / SETTER METHODS ---------------------

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeLastModified() {
        return timeLastModified;
    }

    public void setTimeLastModified(String timeLastModified) {
        this.timeLastModified = timeLastModified;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

// -------------------------- OTHER METHODS --------------------------

    public String geteTag() {
        return eTag;
    }

    public void seteTag(String eTag) {
        this.eTag = eTag;
    }
}
