package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.dto.SinifSabitleri;
import com.Themfg.ELearn.entity.Baglanti;
import com.Themfg.ELearn.repository.BaglantiRepository;
import com.Themfg.ELearn.service.Interface.BaglantiService;
import jakarta.transaction.Transactional;
import org.hibernate.mapping.Bag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BaglantiServiceImpl implements BaglantiService {
    private final BaglantiRepository baglantiRepository;

    public BaglantiServiceImpl(BaglantiRepository baglantiRepository){
        this.baglantiRepository=baglantiRepository;
    }

    @Override
    public boolean mesajAyrintilariniKaydet(Baglanti baglanti){
        if(baglanti.getId() == 0){
            baglanti.setKonum(SinifSabitleri.OPEN);
        }
        Baglanti baglantiKaydet = baglantiRepository.save(baglanti);

        return baglantiKaydet.getId() > 0;
    }

    @Override
    public Page<Baglanti> konumaGoreMesajiBul(PageRequest pageRequest) {
        return baglantiRepository.findByKonum(SinifSabitleri.OPEN,pageRequest);
    }

    @Override
    @Transactional
    public boolean mesajiGuncelle(Long id) {
        Optional<Baglanti> baglanti = baglantiRepository.findById(id);

        baglanti.ifPresent(baglanti1 -> baglanti1.setKonum(SinifSabitleri.CLOSE));

        Baglanti baglantiKaydet = baglantiRepository.save(baglanti.get());
        return baglantiKaydet.getId() > 0;
    }

    @Override
    public List<Baglanti> findBaglantiByKonum(String konum) {
        return baglantiRepository.findByKonum(konum);
    }

    @Override
    public void mesajiSilById(Long id) {
        baglantiRepository.deleteById(id);
    }

    @Override
    public Optional<Baglanti> findBaglantiById(Long id) {
       return baglantiRepository.findById(id);
    }

    @Override
    public void mesajiSil(Baglanti baglanti) {
        baglantiRepository.delete(baglanti);
    }
}
