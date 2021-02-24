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
    public void uploadImage(MultipartFile imageFile, String username)
            throws IOException, ImageSizeException, ImageTypeException {

        // Check if size too big & Check if image jpg or png
        verifyImage(imageFile);                              // Throws an error if not a valid image


        // Sets save path and file extension
        String contentType = imageFile.getContentType();
        String rootDir = System.getProperty("user.dir");     // root directory of the project
        String savePath = rootDir + "/" + dirSavePath;       // save directory path for images
        String fileExtension = getFileExtension(contentType);

        // Save image
        imageFile.transferTo(new File(savePath + username + fileExtension));
    }

    public long getImageMaxSize(){
        return IMAGE_MAX_SIZE/1000000;
    }

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
        if (!isImage){
            throw new ImageTypeException();
        }
    }

    private String getFileExtension(String imageType){
        HashMap<String, String> imageExtensions = new HashMap<>();
        imageExtensions.put("image/jpeg",".jpg");
        imageExtensions.put("image/png",".png");
        return imageExtensions.get(imageType);
    }

}
