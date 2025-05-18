package com.handson.basic.util;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

@Service
public class AWSService {

    @Value("${bucket.url}")
    String bucket;

    @Autowired
    private AmazonS3 s3Client;

    private static final Logger logger = LoggerFactory.getLogger(AWSService.class);

    public void putInBucket(MultipartFile file, String path) {
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile("file" + UUID.randomUUID(), null);
            FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile.toFile());
            saveAndSend(tempFile, path);
        } catch (Exception e) {
            logger.error("Error uploading file to bucket: " + bucket + "/ " + path, e);
            throw new RuntimeException("Failed to upload file to AWS", e);
        } finally {
            if (tempFile != null) {
                try {
                    Files.deleteIfExists(tempFile);
                } catch (IOException ignored) {}
            }
        }
    }



    private void saveAndSend( Path uploadFile, String destPath) throws IOException {
         PutObjectRequest request = new PutObjectRequest(bucket, destPath, uploadFile.toFile());
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("image/png");
        request.setMetadata(metadata);
        s3Client.putObject(request);
    }

    public String generateLink(String fileUrl) {
        return generateLink(bucket, fileUrl);
    }

    public String generateLink(String bucketName, String fileUrl) {
        if (fileUrl == null || fileUrl.isBlank()) return null;
        long expMillis = System.currentTimeMillis() + 1000 * 60 * 60;
        return generateLink(bucketName, fileUrl, expMillis);
    }

    public String generateLink(String bucketName, String key, long expMillis) {
        try {
            Date expiration = new Date(expMillis);

            GeneratePresignedUrlRequest request =
                    new GeneratePresignedUrlRequest(bucketName, key)
                            .withMethod(HttpMethod.GET)
                            .withExpiration(expiration);

            return s3Client.generatePresignedUrl(request).toString();
        } catch (Exception e) {
            logger.error("Error generating presigned link for key: " + key, e);
            throw new RuntimeException("Presigned URL generation failed", e); // אל תבלע
        }
    }


}
