package com.Themfg.ELearn.service.Interface;

import com.Themfg.ELearn.entity.Baglanti;
import org.hibernate.mapping.Bag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface BaglantiService {
    boolean mesajAyrintilariniKaydet(Baglanti baglanti);

    Page<Baglanti> konumaGoreMesajiBul(PageRequest pageRequest);

    boolean mesajiGuncelle(Long id);

    List<Baglanti> findBaglantiByKonum(String konum);

    void mesajiSilById(Long id);

    Optional<Baglanti> findBaglantiById(Long id);

    void mesajiSil(Baglanti baglanti);
}
