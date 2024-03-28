package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.entity.Baglanti;
import com.Themfg.ELearn.entity.Kurs;
import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.entity.Sinif;
import com.Themfg.ELearn.service.Interface.*;
import org.hibernate.mapping.Bag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final BaglantiService baglantiService;
    private final SinifService sinifService;
    private final OgrenciService ogrenciService;
    private final KursService kursService;

    public AdminServiceImpl(BaglantiService baglantiService, SinifService sinifService, OgrenciService ogrenciService, KursService kursService){
        this.baglantiService=baglantiService;
        this.sinifService=sinifService;
        this.ogrenciService=ogrenciService;
        this.kursService=kursService;
    }

    public Page<Baglanti> findMesajVeKonum(PageRequest request){
        return baglantiService.konumaGoreMesajiBul(request);
    }

    public void mesajiGuncelle(Long id){
        baglantiService.mesajiGuncelle(id);
    }

    public void sinifEkle(Sinif sinif){
        sinifService.sinifiKaydet(sinif);
    }

    public void sinifSil(Long id){
        sinifService.sinifiSilById(id);
    }

    public Optional<Sinif> getSinifById(Long id){
        return sinifService.findSinifById(id);
    }

    public String sinifaYeniOgrenciEkle(Sinif sinif, Ogrenci ogrenci){
        Ogrenci ogrenci1 = ogrenciService.findOgrenciByEmail(ogrenci.getEmail());
        if(ogrenci1 == null || !(ogrenci1.getId() > 0 )){
            return "redirect:/admin/ogrencileriGoster?sinifId=" + sinif.getId() + "&error=true";
        }
        ogrenciService.sinifaKaydol(ogrenci1,sinif);
        sinifService.sinifaOgrenciEkle(sinif,ogrenci1);

        return "redirect:/admin/ogrencileriGoster?sinifId="+sinif.getId();
    }

    public List<Sinif> getAllSinif(){
        return sinifService.findAllSinif();
    }

    public void siniftangrenciSil(Sinif sinif,Long id){
        ogrenciService.siniftanAyril(id);
        sinifService.siniftanOgrenciSil(sinif,id);
    }

    public List<Kurs> findAllKurs(){
        return kursService.findAllKurs();
    }

    public void kursEkle(Kurs kurs){
        kursService.kursuKaydet(kurs);
    }

    public Optional<Kurs> getKursById(Long id){
        return kursService.findKursById(id);
    }

    public String kursaOgrenciEkle(Kurs kurs,Ogrenci ogrenci){
        Ogrenci ogrenci1 = ogrenciService.findOgrenciByEmail(ogrenci.getEmail());
        if(ogrenci1 == null || !(ogrenci1.getId() > 0)){
            return "redirect:/admin/ogrencileriGoruntule?id="+kurs.getId() + "&error=true";
        }
        ogrenciService.kursaKaydol(ogrenci1,kurs);
        kursService.kursaYeniOgreniEkle(kurs,ogrenci1);
        return "redirect:/admin/ogrencileriGoruntule?id="+kurs.getId();
    }

    public void kurstanOgrenciSil(Kurs kurs,Long id){
        ogrenciService.kurstanAyril(id,kurs);
        kursService.kurstanOgrenciSil(kurs,id);
    }



}
