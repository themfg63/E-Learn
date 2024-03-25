package com.Themfg.ELearn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Table(name = "sinif")
public class Sinif extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Sınıf adı boş bırakılamaz")
    private String name;

    @OneToMany(mappedBy = "sinif",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,targetEntity = Ogrenci.class)
    private Set<Ogrenci> ogrenci1;

    public void ogreniEkle(Ogrenci ogrenci2){
        if(ogrenci1 == null){
            ogrenci1 = new HashSet<>();
        }
        ogrenci1.add(ogrenci2);
    }

    public void ogreniSil(Ogrenci ogrenci2){
        ogrenci1.remove(ogrenci2);
    }
}
