package edu.mum.wap.socialnetwork.service.impl;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.repository.AdsRepository;
import edu.mum.wap.socialnetwork.repository.impl.AdsRepositoryImpl;
import edu.mum.wap.socialnetwork.service.AdsService;

import java.util.List;

public class AdsServiceImpl implements AdsService {
    private AdsRepository adsRepository = AdsRepositoryImpl.getInstance();
    List<Ads> adsList = adsRepository.getAds();

    @Override
    public Boolean addAds(Ads ad) {
        if(adsRepository.findByAdsId(ad.getId()) == null) {
            adsRepository.saveAds(ad);
            return true;
        }else
            return false;
    }

    @Override
    public void updateAds(Ads ad) {
        Ads tempAd = adsRepository.findByAdsId(ad.getId());

        if(adsList.contains(tempAd)){
            int ind = tempAd.getId() -1;
            adsList.set(ind, ad);
        } else {
            adsRepository.saveAds(tempAd);
        }
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
