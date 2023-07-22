package ru.skypro.ResalePlatforms.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.AdsDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateAdDTO;
import ru.skypro.ResalePlatforms.dto.ExtendedAdDTO;
import ru.skypro.ResalePlatforms.entity.Ad;

public interface AdService {
    public AdsDTO getAllAds();

    public Ad addAd(MultipartFile image, CreateOrUpdateAdDTO ad);

    public ExtendedAdDTO getAdById(int id);

    public void removeAd(int id);

    public Ad updateAd(int id, CreateOrUpdateAdDTO ad);

    public byte[] updateAdImage(int adId, MultipartFile image);

}
