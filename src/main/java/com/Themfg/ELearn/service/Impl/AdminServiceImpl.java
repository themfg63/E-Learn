package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.entity.Baglanti;
import com.Themfg.ELearn.service.Interface.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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



}
