package pt.iscte.hospital.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUploadService {
    void uploadImage(MultipartFile imageFile, String username) throws IOException;
    boolean isImage(String fileType);
}
