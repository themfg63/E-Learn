package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.entity.Kurs;
import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.repository.KursRepository;
import com.Themfg.ELearn.service.Interface.KursService;
import com.Themfg.ELearn.service.Interface.OgrenciService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KursServiceImpl implements KursService {
    private final KursRepository kursRepository;
    private final OgrenciService ogrenciService;

    public KursServiceImpl(KursRepository kursRepository,OgrenciService ogrenciService){
        this.kursRepository=kursRepository;
        this.ogrenciService=ogrenciService;
    }

    @Override
    public List<Kurs> findAllKurs(){
        return kursRepository.findAll(Sort.by("ad").descending());
    }

    @Override
    @Transactional
    public void kursuKaydet(Kurs kurs){
        kursRepository.save(kurs);
    }

    @Override
    public Optional<Kurs> findKursById(Long id){
        return kursRepository.findById(id);
    }

    @Override
    @Transactional
    public void kursaYeniOgreniEkle(Kurs kurs, Ogrenci ogrenci)
    {
        kurs.ogrenciEkle(ogrenci);
        kursRepository.save(kurs);
    }

    @Override
    @Transactional
    public void kurstanOgrenciSil(Kurs kurs, Long id){
        Ogrenci ogrenci = ogrenciService.findOgrenciById(id);
        kurs.ogrenciSil(ogrenci);
        kursRepository.save(kurs);
    }


}
