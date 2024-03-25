package com.Themfg.ELearn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adres")
public class Adres extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Adres bilgisi boş bırakılmamalıdır.")
    @Size(min = 10,max = 250,message = "Lütfen adresinizi tam yazınız.")
    private String adres;

    @NotBlank(message = "Şehir boş bırakılamaz")
    private String sehir;

    @NotBlank(message = "İlçe boş bırakılamaz")
    private String ilce;

    @NotBlank(message = "Posta Kodu Boş bırakılamaz")
    @Size(min = 5,max = 5)
    private String postaKodu;
}
