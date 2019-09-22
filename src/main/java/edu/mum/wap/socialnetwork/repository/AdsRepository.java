package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.Ads;

public interface AdsRepository {
    abstract Ads findByAdsId(Integer Id);
    abstract Ads findByAdsType(String type);
    abstract Ads findByAdsCompany(String company);
    abstract void saveAds(Ads ad);
    abstract void deleteAds(Ads ad);


}
