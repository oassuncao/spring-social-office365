package org.springframework.social.office365.api.impl;

import org.springframework.social.office365.api.FolderOperations;
import org.springframework.social.office365.api.domain.FileSystemItem;
import org.springframework.social.office365.api.domain.Folder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class FolderTemplate extends AbstractTemplate implements FolderOperations {
// ------------------------------ FIELDS ------------------------------

    private final RestTemplate restTemplate;

    private boolean isAuthorized;

    private String url;

// --------------------------- CONSTRUCTORS ---------------------------

    public FolderTemplate(RestTemplate restTemplate, boolean authorized, String baseUrl) {
        this.restTemplate = restTemplate;
        this.isAuthorized = authorized;

        this.url = baseUrl + "/_api/files";
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface FolderOperations ---------------------

    @Override
    public Folder getFolder(String folderPath) {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "(" + folderPath + ")"), Folder.class);
    }

    @Override
    public Folder getRootFolder() {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "/0"), Folder.class);
    }

    @Override
    public List<FileSystemItem> getFolderItems(String folderPath) {
        checkAuthorization(isAuthorized);

        // TODO:
        return restTemplate.getForObject(URI.create(url + "(" + folderPath + ")/Children"), List.class);
    }

    @Override
    public List<FileSystemItem> getRootFolderItems() {
        checkAuthorization(isAuthorized);

        // TODO:
        return restTemplate.getForObject(URI.create(url), List.class);
    }
}
