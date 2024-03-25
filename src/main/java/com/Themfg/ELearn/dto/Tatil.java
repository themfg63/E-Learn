package com.Themfg.ELearn.dto;

import com.Themfg.ELearn.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Type;

@Data
@Entity
@Table(name = "tatil")
public class Tatil extends BaseEntity {
    @Id
    private String gun;

    private String gerekce;

    @Enumerated(EnumType.STRING)
    private Type type;
    public enum Type{
        RESMI, DINI
    }
}
