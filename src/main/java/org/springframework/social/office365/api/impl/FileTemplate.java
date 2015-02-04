package org.springframework.social.office365.api.impl;

import org.springframework.social.office365.api.FileOperations;
import org.springframework.social.office365.api.domain.File;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class FileTemplate extends AbstractTemplate implements FileOperations {
// ------------------------------ FIELDS ------------------------------

    private final RestTemplate restTemplate;

    private boolean isAuthorized;

    private String url;

// --------------------------- CONSTRUCTORS ---------------------------

    public FileTemplate(RestTemplate restTemplate, boolean authorized, String baseUrl) {
        this.restTemplate = restTemplate;
        this.isAuthorized = authorized;

        this.url = baseUrl + "/_api/files";
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface FileOperations ---------------------

    @Override
    public File getFile(String filePath) {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "(" + filePath + ")"), File.class);
    }

    @Override
    public byte[] getFileData(String filePath) {
        checkAuthorization(isAuthorized);

        return restTemplate.getForObject(URI.create(url + "(" + filePath + ")/download"), byte[].class);
    }
}
