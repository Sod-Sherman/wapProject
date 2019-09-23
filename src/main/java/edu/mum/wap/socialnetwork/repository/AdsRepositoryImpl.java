package edu.mum.wap.socialnetwork.repository;

import edu.mum.wap.socialnetwork.model.Ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdsRepositoryImpl implements AdsRepository{

    private List<Ads> adsList;
    private static final AdsRepositoryImpl INSTANCE = new AdsRepositoryImpl();
    private AdsRepositoryImpl(){
        if(this.adsList == null)
            this.adsList = new ArrayList<Ads>(Arrays.asList(
                    new Ads(1, "Facebook", "Connect to Facebook", "http://facebook.com", "https://en.facebookbrand.com/wp-content/uploads/2019/04/f_logo_RGB-Hex-Blue_512.png"),
                    new Ads(2,"Twitter", "Connect to Twitter", "http://twitter.com",  "https://postcron.com/en/blog/wp-content/uploads/2017/01/social-media-image-sizes-2019-min.png")
            ));
    }
    public static AdsRepositoryImpl getInstance() {
        return INSTANCE;
    }
    @Override
    public Ads findByAdsId(Integer Id) {
        for(Ads ad : adsList){
            if(ad.getId()==Id) return ad;
        }
        return null;
    }

    @Override
    public Ads findByAdsType(String type) {
        return null;
    }

    @Override
    public Ads findByAdsCompany(String company) {
        return null;
    }

    @Override
    public void saveAds(Ads ad) {

    }

    @Override
    public void deactivateAds(Ads ad) {
        Ads tempAd = findByAdsId(ad.getId());
        if(tempAd == null) return;
        tempAd.setActive(false);
        saveAds(tempAd);

    }
    public List<Ads> getAds() {return adsList;}
}
