package com.Themfg.ELearn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kurs")
public class Kurs extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ad;

    private String ucret;

    @ManyToMany(mappedBy = "kurs",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Set<Ogrenci> ogrenci = new HashSet<>();

    public void ogrenciEkle(Ogrenci ogrenci){
        this.ogrenci.add(ogrenci);
    }

    public void ogrenciSil(Ogrenci ogrenci){
        this.ogrenci.remove(ogrenci);
    }
}
