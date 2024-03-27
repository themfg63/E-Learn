package com.Themfg.ELearn.service.Impl;

import com.Themfg.ELearn.dto.SinifSabitleri;
import com.Themfg.ELearn.entity.Kurs;
import com.Themfg.ELearn.entity.Ogrenci;
import com.Themfg.ELearn.entity.Role;
import com.Themfg.ELearn.entity.Sinif;
import com.Themfg.ELearn.repository.OgrenciRepository;
import com.Themfg.ELearn.service.Interface.OgrenciService;
import com.Themfg.ELearn.service.Interface.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class OgrenciServiceImpl implements OgrenciService {
    private final OgrenciRepository ogrenciRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    public OgrenciServiceImpl(OgrenciRepository ogrenciRepository,RoleService roleService,PasswordEncoder  passwordEncoder){
        this.ogrenciRepository=ogrenciRepository;
        this.roleService=roleService;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    @Transactional
    public Ogrenci ogrenciKaydet(Ogrenci ogrenci){
        Role role = roleService.findRoleByName(SinifSabitleri.OGRENCI_ROLE);
        ogrenci.setRole(role);
        ogrenci.setSifre(passwordEncoder.encode(ogrenci.getSifre()));
        return ogrenciRepository.save(ogrenci);
    }

    @Override
    @Transactional
    public Ogrenci ogrenciGuncelle(Ogrenci ogrenci){
        System.out.println("Servis: " + ogrenci);
        return ogrenciRepository.save(ogrenci);
    }

    @Override
    public Ogrenci findOgrenciByEmail(String email){
        return ogrenciRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void siniftanAyril(Long id){
        ogrenciRepository.findById(id).ifPresent(ogrenci -> {ogrenci.siniftanCik(); ogrenciRepository.save(ogrenci);});
    }

    @Override
    @Transactional
    public void sinifaKaydol(Ogrenci ogrenci, Sinif sinif){
        ogrenci.derseKaydol(sinif);
        ogrenciRepository.save(ogrenci);
    }

    @Override
    public Ogrenci findOgrenciById(Long id){
        return ogrenciRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void kursaKaydol(Ogrenci ogrenci, Kurs kurs){
        ogrenci.kursaKaydol(kurs);
        ogrenciRepository.save(ogrenci);
    }

    @Override
    public void kurstanAyril(Long id, Kurs kurs){
        ogrenciRepository.findById(id).ifPresent(ogrenci -> {
            ogrenci.kurstanCik(kurs);
            ogrenciRepository.save(ogrenci);
        });
    }
}
