package pt.iscte.hospital.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pt.iscte.hospital.exceptions.ImageSizeException;
import pt.iscte.hospital.exceptions.ImageTypeException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {
    private static final String dirSavePath = "uploaded_images/";
    private static final long IMAGE_MAX_SIZE = 1000000L;   // Size in bytes
    private static final String[] IMAGE_TYPES = {"image/jpeg", "image/png"};

    // Methods
    @Override
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
    public String uploadImage(MultipartFile imageFile, String username)
            throws IOException, ImageSizeException, ImageTypeException {

        // Check if size too big & Check if image jpg or png
        verifyImage(imageFile);                              // Throws an error if not a valid image

        // Sets save path and file extension
        String contentType = imageFile.getContentType();
        String rootDir = System.getProperty("user.dir");     // root directory of the project
        String savePath = rootDir + "/" + dirSavePath;       // save directory path for images
        String fileExtension = getFileExtension(contentType);
        String fileName = username + fileExtension;

        // Save image
        imageFile.transferTo(new File(savePath + fileName));

        return fileName;
    }

    /**
     * @return Max image size that can be uploaded. Value in <b>MB</b>.
     */
    @Override
    public long getImageMaxSize() {
        return IMAGE_MAX_SIZE / 1000000;
    }

    /**
     * Throws an Exception if the image file is bigger than the IMAGE_MAX_SIZE constant or if the file extension is not
     * ".jpg" or ".png".
     *
     * @param imageFile A MultipartFile object with an Image file.
     * @return void.
     * @throws ImageSizeException On exceeded file size.
     * @throws ImageTypeException On invalid image extension.
     */
    private void verifyImage(MultipartFile imageFile) throws ImageSizeException, ImageTypeException {
        String contentType = imageFile.getContentType();
        boolean isImage = false;

        // Check if size too big
        if (imageFile.getSize() > IMAGE_MAX_SIZE) {
            throw new ImageSizeException();
        }

        // Check if image jpg or png
        for (String imageType : IMAGE_TYPES) {
            if (contentType.equals(imageType)) {
                isImage = true;
                break;
            }
        }
        if (!isImage) {
            throw new ImageTypeException();
        }
    }

    /**
     * Gives the image extension for a given MIME type: ".jpg" or ".png".
     *
     * @param imageType A String with the file MIME type.
     * @return for imageType="image/jpeg" return ".jpg".<br>
     * for imageType="image/png" return ".png".</br>
     */
    @Override
    public String getFileExtension(String imageType) {
        HashMap<String, String> imageExtensions = new HashMap<>();
        imageExtensions.put("image/jpeg", ".jpg");
        imageExtensions.put("image/png", ".png");
        return imageExtensions.get(imageType);
    }

}
