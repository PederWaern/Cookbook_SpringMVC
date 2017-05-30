package se.nackademin.mvcgruppen.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import org.cloudinary.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

@Service
public class UploadService {
    private final String mCloudName;
    private final String mApiKey;
    private final String mApiSecret;

    @Autowired
    public UploadService(@Qualifier("com.cloudinary.cloud_name") String mCloudName,
                         @Qualifier("com.cloudinary.api_key") String mApiKey,
                         @Qualifier("com.cloudinary.api_secret") String mApiSecret) {
        this.mCloudName = mCloudName;
        this.mApiKey = mApiKey;
        this.mApiSecret = mApiSecret;

    }

    public String cloudUpload(MultipartFile aFile) {
        Cloudinary cloudinary = new Cloudinary("cloudinary://"
                + mApiKey + ":"
                + mApiSecret + "@"
                + mCloudName);


        try {
            File fData = Files.createTempFile("temp", aFile.getOriginalFilename()).toFile();
            aFile.transferTo(fData);
            Map options = ObjectUtils.asMap(
                    "transformation", new Transformation().width(400).height(400).crop("limit")
            );
            Map response = cloudinary.uploader().upload(fData, options);
            JSONObject json = new JSONObject(response);

            return json.getString("url");
        } catch (Exception e) {
            return "Error uploading image";
        }
    }


}
