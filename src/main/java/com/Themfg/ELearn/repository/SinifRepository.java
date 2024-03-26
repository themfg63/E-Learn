package com.Themfg.ELearn.repository;

import com.Themfg.ELearn.entity.Sinif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinifRepository extends JpaRepository<Sinif,Long> {
}
