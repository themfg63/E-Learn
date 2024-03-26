package com.Themfg.ELearn.service.Interface;

import com.Themfg.ELearn.entity.Baglanti;
import com.Themfg.ELearn.entity.Kurs;
import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.entity.Sinif;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Page<Baglanti> findMesajVeKonum(PageRequest request);

    void mesajiGuncelle(Long id);

    void sinifEkle(Sinif sinif);

    void sinifSil(Long id);

    Optional<Sinif> getSinifById(Long id);

    String sinifaYeniOgrenciEkle(Sinif sinif, Ogrenci ogrenci);

    List<Sinif> getAllSinif();

    void siniftanOgrenciSil(Sinif sinif,Long id);

    List<Kurs> findAllKurs();

    void kursEkle(Kurs kurs);

    Optional<Kurs> getKursById(Long id);

    String kursaOgrenciEkle(Kurs kurs, Ogrenci ogrenci);

    void kurstanOgrenciSil(Kurs kurs,Long id);
}
