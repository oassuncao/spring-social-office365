package org.springframework.social.office365.api.impl;

import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.office365.api.FileOperations;
import org.springframework.social.office365.api.FolderOperations;
import org.springframework.social.office365.api.Office365;
import org.springframework.social.office365.api.UserOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public class Office365Template extends AbstractOAuth2ApiBinding implements Office365 {
// ------------------------------ FIELDS ------------------------------

    public static final String SHARE_POINT_BASE_URL = "https://graph.windows.net";
    public static final String GRAPH_BASE_URL = "https://graph.windows.net";


    private FileOperations fileOperations;
    private UserOperations userOperations;
    private FolderOperations folderOperations;

// --------------------------- CONSTRUCTORS ---------------------------

    public Office365Template(String accessToken) {
        super(accessToken);
        this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized(), GRAPH_BASE_URL);
        this.folderOperations = new FolderTemplate(getRestTemplate(), isAuthorized(), SHARE_POINT_BASE_URL);
        this.fileOperations = new FileTemplate(getRestTemplate(), isAuthorized(), SHARE_POINT_BASE_URL);
    }

// --------------------- GETTER / SETTER METHODS ---------------------

    @Override
    protected List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter());
        messageConverters.add(getFormMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        ByteArrayHttpMessageConverter byteArrayMessageConverter = getByteArrayMessageConverter();
        byteArrayMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(byteArrayMessageConverter);
        return messageConverters;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface Office365 ---------------------

    @Override
    public UserOperations userOperations() {
        return userOperations;
    }

    @Override
    public FileOperations fileOperations() {
        return fileOperations;
    }

    @Override
    public FolderOperations folderOperations() {
        return folderOperations;
    }
}
