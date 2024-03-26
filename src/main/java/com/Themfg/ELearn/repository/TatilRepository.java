package com.Themfg.ELearn.repository;

import com.Themfg.ELearn.entity.Tatil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TatilRepository extends JpaRepository<Tatil,Long> {
}
