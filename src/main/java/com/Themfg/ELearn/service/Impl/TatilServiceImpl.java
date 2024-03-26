package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.entity.Tatil;
import com.Themfg.ELearn.repository.TatilRepository;
import com.Themfg.ELearn.service.Interface.TatilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TatilServiceImpl implements TatilService {
    private final TatilRepository tatilRepository;

    public TatilServiceImpl(TatilRepository tatilRepository){
        this.tatilRepository=tatilRepository;
    }

    @Override
    public List<Tatil> findAllTatil(){
        return (List<Tatil>) tatilRepository.findAll()  ;
    }
}
