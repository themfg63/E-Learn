package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.dto.User;
import com.Themfg.ELearn.entity.Adres;
import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.service.Interface.OgrenciService;
import com.Themfg.ELearn.service.Interface.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final OgrenciService ogrenciService;

    public UserServiceImpl(OgrenciService ogrenciService){
        this.ogrenciService=ogrenciService;
    }

    public User profilBilgileriniDoldur(Ogrenci ogrenci){
        User user = new User() ;
        user.setAd(ogrenci.getAd());
        user.setTelNo(ogrenci.getTelNo());
        user.setEmail(ogrenci.getEmail());
        if(ogrenci.getAdres() != null){
            user.setAdres(ogrenci.getAdres().getAdres());
            user.setSehir(ogrenci.getAdres().getSehir());
            user.setKonum(ogrenci.getAdres().getKonum());
            user.setPostaKodu(ogrenci.getAdres().getPostaKodu());
        }
        return user;
    }

    public Ogrenci profiliGuncelle(Ogrenci ogrenci, User user){
        ogrenci.setAd(user.getAd());
        ogrenci.setEmail(user.getEmail());
        ogrenci.setTelNo(user.getTelNo());
        if(ogrenci.getAdres() == null ||!(ogrenci.getAdres().getId() > 0)){
            ogrenci.setAdres(new Adres());
        }
        ogrenci.getAdres().setAdres(user.getAdres());
        ogrenci.getAdres().setSehir(user.getSehir());
        ogrenci.getAdres().setKonum(user.getKonum());
        ogrenci.getAdres().setPostaKodu(user.getPostaKodu());

        return ogrenciService.ogrenciGuncelle(ogrenci);
    }
}
