package edu.mum.wap.socialnetwork.service.impl;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.repository.AdsRepository;
import edu.mum.wap.socialnetwork.repository.impl.AdsRepositoryImpl;
import edu.mum.wap.socialnetwork.service.AdsService;

import java.util.List;

public class AdsServiceImpl implements AdsService {
    private AdsRepository adsRepository = AdsRepositoryImpl.getInstance();


    @Override
    public Boolean addAds(Ads ad) {
        if(adsRepository.findByAdsId(ad.getId()) == null) {
            adsRepository.saveAds(ad);
            return true;
        }else
            return false;
    }

    @Override
    public Boolean updateAds(Ads ad) {
        Ads tempAd = adsRepository.findByAdsId(ad.getId());
        if(tempAd == null) return false;
        else {
            tempAd.setActive(ad.isActive());
            tempAd.setArticle(ad.getArticle());
            tempAd.setContent(ad.getContent());
            tempAd.setUrl(ad.getUrl());
            tempAd.setImgUrl(ad.getImgUrl());
            tempAd.setLocation(ad.getLocation());
            tempAd.setAgeRangeMax(ad.getAgeRangeMax());
            tempAd.setDuration(ad.getDuration());
        }
        adsRepository.saveAds(tempAd);
        return true;
    }

    @Override
    public void deactivateAds(Ads ad) {
        adsRepository.deactivateAds(ad);
    }

    @Override
    public List<Ads> getAllAds() {
        return adsRepository.getAds();
    }


    @Override
    public Ads findByAdsId(Integer id) {
        return adsRepository.findByAdsId(id);
    }
}
