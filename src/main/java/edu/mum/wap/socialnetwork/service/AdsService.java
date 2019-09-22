package edu.mum.wap.socialnetwork.service;

import edu.mum.wap.socialnetwork.model.Ads;

import java.util.List;

public interface AdsService {
    public abstract Boolean addAds(Ads ad);
    public abstract void updateAds(Ads ad);
    public abstract void deactivateAds(Ads ad);

    abstract Ads findByAdsId(Integer id);
}
