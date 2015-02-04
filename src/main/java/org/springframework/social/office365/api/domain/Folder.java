package org.springframework.social.office365.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Folder extends FileSystemItem {
// ------------------------------ FIELDS ------------------------------

    @JsonProperty("Children")
    List<FileSystemItem> children = new ArrayList<FileSystemItem>();

    @JsonProperty("ChildrenCount")
    private Long childrenCount;

// --------------------- GETTER / SETTER METHODS ---------------------

    public List<FileSystemItem> getChildren() {
        return children;
    }

    public void setChildren(List<FileSystemItem> children) {
        this.children = children;
    }

    public Long getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Long childrenCount) {
        this.childrenCount = childrenCount;
    }
}
