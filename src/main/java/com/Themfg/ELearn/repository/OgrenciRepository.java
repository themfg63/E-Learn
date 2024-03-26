package com.Themfg.ELearn.repository;

import com.Themfg.ELearn.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OgrenciRepository extends JpaRepository<Ogrenci,Long> {
    Ogrenci findByEmail(String email);
}
