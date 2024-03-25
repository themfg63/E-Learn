package com.Themfg.ELearn.dto;

import com.Themfg.ELearn.entity.BaseEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Baglanti extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ad boş bırakılamaz")
    @Size(min = 3,message = "Adınız en az 3 karakterden oluşmalıdır")
    private String name;

    @NotBlank(message = "Telefon numarası boş bırakılamaz")
    @Size(min = 11,max = 11,message = "11 haneli telefonunuzu giriniz")
    private String telNo;

    @NotBlank(message = "E-Mail boş bırakılamaz")
    @Email(message = "Lütfen Mail formatında bir adres giriniz")
    private String email;

    @NotBlank(message = "Konu kısmı boş bırakılamaz")
    private String konu;

    @NotBlank(message = "Lütfen Mesajınızı yazınız")
    private String mesaj;

    private String konum;
}
