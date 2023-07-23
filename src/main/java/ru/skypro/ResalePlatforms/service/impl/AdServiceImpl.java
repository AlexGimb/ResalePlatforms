package ru.skypro.ResalePlatforms.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.ResalePlatforms.dto.AdDTO;
import ru.skypro.ResalePlatforms.dto.AdsDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateAdDTO;
import ru.skypro.ResalePlatforms.dto.ExtendedAdDTO;
import ru.skypro.ResalePlatforms.entity.Ad;
import ru.skypro.ResalePlatforms.entity.UserClient;
import ru.skypro.ResalePlatforms.repository.AdRepository;
import ru.skypro.ResalePlatforms.service.AdService;
import ru.skypro.ResalePlatforms.service.ImageService;

import java.io.IOException;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {
    private final AdRepository adRepository;
    private final ImageService imageService;

    private final UserServiceImpl userService;

    public AdServiceImpl(AdRepository adRepository, ImageService imageService, UserServiceImpl userService) {
        this.adRepository = adRepository;
        this.imageService = imageService;
        this.userService = userService;
    }

    /**
     * Получает все объявления.
     *
     * @return объект Ads с информацией о объявлениях
     */
    @Override
    public AdsDTO getAllAds() {
        List<Ad> adList = adRepository.findAll();
        int totalCount = adList.size();

        AdsDTO ads = new AdsDTO();
        ads.setCount(totalCount);
        ads.setResults(adList);

        return ads;
    }

    /**
     * Добавляет новое объявление.
     *
     * @param image файл изображения для объявления
     * @param ad    объект CreateOrUpdateAd с данными объявления
     * @return объект Ad с информацией о добавленном объявлении
     */
    @Override
    public AdDTO addAd(MultipartFile image, CreateOrUpdateAdDTO ad) {
        String imageUrl = imageService.uploadImage(image);
        UserClient userClient = userService.getAuthenticatedUser();

        Ad newAd = new Ad();
        newAd.setAuthor(userClient);
        newAd.setTitle(ad.getTitle());
        newAd.setDescription(ad.getDescription());
        newAd.setPrice(ad.getPrice());
        newAd.setImage(imageUrl);

        Ad createdAd = adRepository.save(newAd);

        AdDTO adDTO = new AdDTO();
        adDTO.setPk(createdAd.getId());
        adDTO.setTitle(createdAd.getTitle());
        adDTO.setDescription(createdAd.getDescription());
        adDTO.setPrice(createdAd.getPrice());
        adDTO.setImage(createdAd.getImage());

        return adDTO;
    }

    /**
     * Получает информацию об объявлении по его идентификатору.
     *
     * @param id идентификатор объявления
     * @return объект ExtendedAd с информацией об объявлении
     * @throws ResponseStatusException если объявление не найдено
     */
    @Override
    public ExtendedAdDTO getAdById(int id) {
        return adRepository.findById(id)
                .map(this::convertToExtendedAd)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Объявление не найдено"));
    }

    /**
     * Удаляет объявление по его идентификатору.
     *
     * @param id идентификатор объявления
     * @throws ResponseStatusException если объявление не найдено
     */
    @Override
    public void removeAd(int id) {
        if (!adRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Объявление не найдено found");

        }
        adRepository.deleteById(id);
    }

    /**
     * Обновляет информацию об объявлении.
     *
     * @param id идентификатор объявления
     * @param ad объект CreateOrUpdateAd с обновленными данными объявления
     * @return объект Ad с обновленной информацией об объявлении
     * @throws ResponseStatusException если объявление не найдено
     */
    @Override
    public AdDTO updateAd(int id, CreateOrUpdateAdDTO ad) {
        Ad existingAd = adRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Объявление не найдено"));

        existingAd.setTitle(ad.getTitle());
        existingAd.setDescription(ad.getDescription());
        existingAd.setPrice(ad.getPrice());

        Ad updatedAd = adRepository.save(existingAd);

        AdDTO adDTO = new AdDTO();
        adDTO.setPk(updatedAd.getId());
        adDTO.setTitle(updatedAd.getTitle());
        adDTO.setDescription(updatedAd.getDescription());
        adDTO.setPrice(updatedAd.getPrice());
        adDTO.setImage(updatedAd.getImage());

        return adDTO;
    }

    /**
     * Обновляет изображение объявления.
     *
     * @param adId  идентификатор объявления
     * @param image файл изображения для обновления
     * @return массив байтов с обновленным изображением
     * @throws ResponseStatusException если объявление не найдено
     */
    @Override
    public byte[] updateAdImage(int adId, MultipartFile image) {
        Ad existingAd = adRepository.findById(adId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Объявление не найдено"));
        // Загружаем изображение на сервер или в облачное хранилище и получаем URL
        String imageUrl = imageService.uploadImage(image);
        existingAd.setImage(imageUrl);
        adRepository.save(existingAd);
        try {
            return image.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ExtendedAdDTO convertToExtendedAd(Ad ad) {
        ExtendedAdDTO extendedAd = new ExtendedAdDTO();
        extendedAd.setPk(ad.getPk());
        extendedAd.setTitle(ad.getTitle());
        extendedAd.setDescription(ad.getDescription());
        extendedAd.setPrice(ad.getPrice());
        extendedAd.setImage(ad.getImage());

        return extendedAd;
    }
}
