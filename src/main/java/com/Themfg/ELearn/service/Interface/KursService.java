package com.Themfg.ELearn.service.Interface;

import com.Themfg.ELearn.entity.Kurs;
import com.Themfg.ELearn.entity.Ogrenci;

import java.util.List;
import java.util.Optional;

public interface KursService {
    List<Kurs> findAllKurs();
    void kursuKaydet(Kurs kurs);
    Optional<Kurs> findKursById(Long id);
    void kursaYeniOgreniEkle(Kurs kurs, Ogrenci ogrenci);
    void kurstanOgrenciSil(Kurs kurs,Long id);
}
