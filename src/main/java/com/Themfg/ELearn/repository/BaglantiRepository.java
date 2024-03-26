package com.Themfg.ELearn.repository;

import com.Themfg.ELearn.entity.Baglanti;
import org.hibernate.mapping.Bag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaglantiRepository extends JpaRepository<Baglanti,Long>
{
    List<Baglanti> findByKonum(String konum);

    Page<Baglanti> findByKonum(String konum, Pageable pageable);
}
