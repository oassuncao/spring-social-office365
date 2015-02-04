package org.springframework.social.office365.api;

import org.springframework.social.ApiBinding;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public interface Office365 extends ApiBinding {
// ------------------------------ FIELDS ------------------------------

    public static final String PROVIDER_NAME = "office365";

// -------------------------- OTHER METHODS --------------------------

    FileOperations fileOperations();

    FolderOperations folderOperations();

    UserOperations userOperations();
}
