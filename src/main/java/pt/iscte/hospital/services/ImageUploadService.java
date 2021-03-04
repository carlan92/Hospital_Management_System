package pt.iscte.hospital.services;

import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;

import java.io.IOException;

public interface ImageUploadService {
    /**
     * Saves the uploaded image.
     *
     * @param imageFile A MultipartFile object with an Image file.
     * @param username A String with the username name. It will be used to name the image.
     * @return String with the name of the file has it was saved.
     * @throws IOException If it was not possible to save the image file
     * @throws ImageSizeException On exceeded file size.
     * @throws ImageTypeException On invalid image extension.
     */
    String uploadImage(MultipartFile imageFile, String username)
            throws IOException, ImageSizeException, ImageTypeException;

    /**
     * @return Max image size that can be uploaded. Value in <b>MB</b>.
     */
    long getImageMaxSize();

    /**
     * Gives the image extension for a given MIME type: ".jpg" or ".png".
     *
     * @param imageType A String with the file MIME type.
     * @return for imageType="image/jpeg" return ".jpg".<br>
     * for imageType="image/png" return ".png".</br>
     */
    String getFileExtension(String imageType);
}
