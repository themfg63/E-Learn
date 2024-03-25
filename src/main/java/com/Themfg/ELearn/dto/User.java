package com.Themfg.ELearn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {
    private String ad;
    private String telNo;
    private String email;
    private String adres;
    private String sehir;
    private String konum;
    private String postaKodu;
}
