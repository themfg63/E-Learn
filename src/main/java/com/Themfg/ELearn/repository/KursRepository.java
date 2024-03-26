package com.Themfg.ELearn.repository;

import com.Themfg.ELearn.entity.Kurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KursRepository extends JpaRepository<Kurs,Long> {
    List<Kurs> findAllByOrderByNameDesc();
    List<Kurs> findAllByOrderByName();
}
