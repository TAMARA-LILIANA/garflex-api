package com.garflex.storage;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.garflex.storage.interfaces.IAzureStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AzureStorageService implements IAzureStorageService {

    @Value("${spring.cloud.azure.storage.blob.container-name}")
    private String containerName;

    @Value("${spring.blob.storage.connection-string}")
    private String connectionString;

    private BlobServiceClient blobServiceClient;

    public BlobClient init(String name){
        System.out.println(connectionString);
        blobServiceClient = new BlobServiceClientBuilder()
                .connectionString(connectionString)
                .buildClient();

        String fileName = name;
        BlobClient blobClient = blobServiceClient
                .getBlobContainerClient(containerName)
                .getBlobClient(fileName);
        return blobClient;
    }

    @Override
    public String saveFile(MultipartFile file) {
        try {
            BlobClient blobClient = init(file.getOriginalFilename());
            blobClient.upload(file.getInputStream(), file.getSize(),true);
            return blobClient.getBlobUrl();
        }catch (IOException ex){
            return "";
        }
    }

    @Override
    public void deleteFile(String name) {
        BlobClient blobClient = init(name);
        blobClient.delete();
    }
}
