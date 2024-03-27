package com.Themfg.ELearn.service.Interface;

import com.Themfg.ELearn.entity.Kurs;
import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.entity.Sinif;

public interface OgrenciService {
    Ogrenci ogrenciKaydet(Ogrenci ogrenci);
    Ogrenci ogrenciGuncelle(Ogrenci ogrenci);
    Ogrenci findOgrenciByEmail(String email);
    void siniftanAyril(Long id);
    void sinifaKaydol(Ogrenci ogrenci, Sinif sinif);
    Ogrenci findOgrenciById(Long id);
    void kursaKaydol(Ogrenci ogrenci, Kurs kurs);
    void kurstanAyril(Long id, Kurs kurs);
}
