package com.Themfg.ELearn.repository;

import com.Themfg.ELearn.entity.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresRepository extends JpaRepository<Adres,Long> {
}
