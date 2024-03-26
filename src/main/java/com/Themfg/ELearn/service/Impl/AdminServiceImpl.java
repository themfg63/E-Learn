package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.service.Interface.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final BaglantiService baglantiService;
    private final SinifService sinifService;
    private final OgrenciService ogrenciService;
    private final KursService kursService;
}
