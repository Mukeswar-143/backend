package in.mukesh.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.mukesh.entity.ImageEntity;
import in.mukesh.repository.ImageRepository;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageEntity saveImage(MultipartFile file) throws IOException {
        ImageEntity image = new ImageEntity();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setImageData(file.getBytes());
        return imageRepository.save(image);
    }

    public Optional<ImageEntity> getImage(Long id) {
        return imageRepository.findById(id);
    }
}
