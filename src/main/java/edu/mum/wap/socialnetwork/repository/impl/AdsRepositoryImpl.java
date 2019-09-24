package edu.mum.wap.socialnetwork.repository.impl;

import edu.mum.wap.socialnetwork.model.Ads;
import edu.mum.wap.socialnetwork.repository.AdsRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdsRepositoryImpl implements AdsRepository {

    private List<Ads> adsList;
    private static final AdsRepositoryImpl INSTANCE = new AdsRepositoryImpl();
    private AdsRepositoryImpl(){
        if(this.adsList == null)
            this.adsList = new ArrayList<Ads>(Arrays.asList(
                    new Ads(true,1, "Facebook", "Connect to Facebook", "http://facebook.com", "https://en.facebookbrand.com/wp-content/uploads/2019/04/f_logo_RGB-Hex-Blue_512.png", LocalDate.of(2019,9,21), "USA", 45, 14),
                    new Ads(true,2,"Twitter", "Connect to Twitter", "http://twitter.com",  "https://postcron.com/en/blog/wp-content/uploads/2017/01/social-media-image-sizes-2019-min.png", LocalDate.of(2019,9,21), "USA", 45, 14),
                    new Ads(true, 3, "Instagram", "Connect to Instagram", "http://instagram.com", "https://en.facebookbrand.com/wp-content/uploads/2019/04/f_logo_RGB-Hex-Blue_512.png", LocalDate.of(2019,9,22), "USA", 45, 14),
                    new Ads(true, 4,"Twitch", "Connect to Twitch", "http://twitch.com",  "https://postcron.com/en/blog/wp-content/uploads/2017/01/social-media-image-sizes-2019-min.png", LocalDate.of(2019,9,23), "USA", 45, 14)
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
        this.adsList.add(ad);
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
