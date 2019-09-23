package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.Ads;

import java.util.List;

public interface AdsRepository {
    abstract Ads findByAdsId(Integer Id);
    abstract Ads findByAdsType(String type);
    abstract Ads findByAdsCompany(String company);
    abstract void saveAds(Ads ad);
    abstract void deactivateAds(Ads ad);
    abstract List<Ads> getAds();


}
