package br.com.projetoconest.api.service;

import br.com.projetoconest.api.model.entities.Image;
import br.com.projetoconest.api.repository.ImageRepository;
import br.com.projetoconest.api.utils.ImageUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    public Image uploadImage(MultipartFile file) throws IOException {
        if(file == null){
            return null;
        }
        return imageRepository.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .image(ImageUtility.compressImage(file.getBytes())).build());
    }

    public Image getImageDetails(String name) {

        final Optional<Image> dbImage = imageRepository.findByName(name);

        return Image.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .image(ImageUtility.decompressImage(dbImage.get().getImage())).build();
    }

    public byte[] getImage(String name) {

        final Optional<Image> dbImage = imageRepository.findByName(name);

        return ImageUtility.decompressImage(dbImage.get().getImage());
    }

}
