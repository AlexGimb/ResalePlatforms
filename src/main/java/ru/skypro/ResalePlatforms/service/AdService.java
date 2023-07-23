package ru.skypro.ResalePlatforms.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.ResalePlatforms.dto.AdDTO;
import ru.skypro.ResalePlatforms.dto.AdsDTO;
import ru.skypro.ResalePlatforms.dto.CreateOrUpdateAdDTO;
import ru.skypro.ResalePlatforms.dto.ExtendedAdDTO;

public interface AdService {
    public AdsDTO getAllAds();

    AdDTO addAd(MultipartFile image, CreateOrUpdateAdDTO ad);

    public ExtendedAdDTO getAdById(int id);

    public void removeAd(int id);

    public AdDTO updateAd(int id, CreateOrUpdateAdDTO ad);

    public byte[] updateAdImage(int adId, MultipartFile image);

}
