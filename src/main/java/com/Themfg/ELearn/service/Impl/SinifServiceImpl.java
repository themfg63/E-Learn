package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.entity.Sinif;
import com.Themfg.ELearn.repository.SinifRepository;
import com.Themfg.ELearn.service.Interface.OgrenciService;
import com.Themfg.ELearn.service.Interface.SinifService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinifServiceImpl implements SinifService {
    private final SinifRepository sinifRepository;
    private final OgrenciService ogrenciService;
    public SinifServiceImpl(SinifRepository sinifRepository,OgrenciService ogrenciService){
        this.ogrenciService=ogrenciService;
        this.sinifRepository=sinifRepository;
    }

    @Override
    public Optional<Sinif> findSinifById(Long id){
        return sinifRepository.findById(id);
    }

    @Override
    @Transactional
    public void sinifiKaydet(Sinif sinif ){
        sinifRepository.save(sinif);
    }

    @Override
    @Transactional
    public void sinifiSilById(Long id){
        sinifRepository.findById(id).ifPresent(sinif -> {
            for(Ogrenci ogrenci : sinif.getOgrenci1()){
                ogrenciService.siniftanAyril(ogrenci.getId());
            }
            sinifRepository.deleteById(id);
        });
    }

    @Override
    @Transactional
    public void sinifaOgrenciEkle(Sinif sinif,Ogrenci ogrenci){
        sinif.ogreniEkle(ogrenci);
        sinifRepository.save(sinif);
    }

    @Override
    public List<Sinif> findAllSinif(){
        return sinifRepository.findAll();
    }

    @Override
    @Transactional
    public void siniftanOgrenciSil(Sinif sinif,Long id){
        Ogrenci ogrenci = ogrenciService.findOgrenciById(id);
        sinif.ogreniSil(ogrenci);
        sinifRepository.save(sinif);
    }
}
