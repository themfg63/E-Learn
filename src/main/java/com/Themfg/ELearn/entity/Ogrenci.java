package com.Themfg.ELearn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "ogrenci")
public class Ogrenci extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ad boş bırakılamaz")
    @Size(min = 3,message = "Adınız en az 3 karakterden oluşmalı")
    private String ad;

    @NotBlank(message = "Telefon numarası boş bırakılamaz")
    @Size(min = 11,max = 11,message = "Telefon numaranızı eksik veya hatalı girdiniz")
    private String telNo;

    @NotBlank(message = "E-Mail adresi boş bırakılamaz")
    @Email(message = "Lütfen E-Mail formatında bir adres giriniz")
    private String email;

    @NotBlank(message = "Şifre boş bırakılamaz")
    @Size(min = 6,message = "Şifreniz en az 6 karakterden oluşmalıdır")
    private String sifre;

    @NotBlank(message = "Şifre Tekrarı boş bırakılamaz")
    @Size(min = 6)
    private String sifreTekrar;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id",referencedColumnName = "id",nullable = false)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adres_id",referencedColumnName = "id",nullable = false)
    private Adres adres;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sinif_id",nullable = false)
    private Sinif sinif;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinTable(name = "ogrenci_kurs",joinColumns = @JoinColumn(name = "ogrenci_id"),inverseJoinColumns = @JoinColumn(name = "kurs_id"))
    private Set<Kurs> kurs = new HashSet<>();

    public void derseKaydol(Sinif sinif){
        this.sinif=sinif;
    }

    public void siniftanCik(){
        this.sinif=null;
    }

    public void kursaKaydol(Kurs kurs){
        this.kurs.add(kurs);
    }

    public void kurstanCik(Kurs kurs){
        this.kurs.remove(kurs);
    }
}
