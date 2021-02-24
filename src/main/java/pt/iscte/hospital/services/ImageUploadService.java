package pt.iscte.hospital.services;

import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;

import java.io.IOException;

public interface ImageUploadService {
    void uploadImage(MultipartFile imageFile, String username)
            throws IOException, ImageSizeException, ImageTypeException;
}
