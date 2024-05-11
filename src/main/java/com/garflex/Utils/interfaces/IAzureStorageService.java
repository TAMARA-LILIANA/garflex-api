package com.garflex.Utils.interfaces;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface IAzureStorageService {
    String saveFile(MultipartFile file) throws IOException;
    void deleteFile(String name);
}
