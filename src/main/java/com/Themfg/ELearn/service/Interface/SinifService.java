package com.Themfg.ELearn.service.Interface;

import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.entity.Sinif;

import java.util.List;
import java.util.Optional;

public interface SinifService {
    Optional<Sinif> findSinifById(Long id);
    void sinifiKaydet(Sinif sinif);
    void sinifiSilById(Long id);
    void sinifaOgrenciEkle(Sinif sinif, Ogrenci ogrenci);
    List<Sinif> findAllSinif();
    void siniftanOgrenciSil(Sinif sinif,Long id);
}
