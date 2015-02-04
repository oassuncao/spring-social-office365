package org.springframework.social.office365.api;

import org.springframework.social.office365.api.domain.FileSystemItem;
import org.springframework.social.office365.api.domain.Folder;

import java.util.List;

/**
 * Created by: Alireza Afrasiabian (aafrasiabian)
 * Date: 24/07/2014
 */
public interface FolderOperations {
// -------------------------- OTHER METHODS --------------------------

    Folder getFolder(String folderPath);

    List<FileSystemItem> getFolderItems(String folderPath);

    Folder getRootFolder();

    List<FileSystemItem> getRootFolderItems();
}
