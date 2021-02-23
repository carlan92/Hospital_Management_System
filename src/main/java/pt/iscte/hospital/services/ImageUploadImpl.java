package pt.iscte.hospital.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class ImageUploadImpl implements ImageUploadService {
    private static final String dirSavePath = "uploaded_images/";

    @Override
    public void uploadImage(MultipartFile imageFile, String username) throws IOException {
        // TODO check if image jpg
        // TODO check if size too large
        // TODO permitir guardar por cima se já existir uma imagem
        String rootDir = System.getProperty("user.dir"); // root directory of the project
        String savePath = rootDir + "/" + dirSavePath;
        //TODO

        imageFile.transferTo(new File(savePath + username + ".jpg"));
    }

    @Override
    public boolean isImage(String fileType) {
        //TODO
        return true;
    }

}
