package com.Themfg.ELearn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedBy
    @Column(updatable = false)
    @JsonIgnore
    private LocalDateTime olusturmaTarihi;

    @CreatedBy
    @Column(updatable = false)
    @JsonIgnore
    private String olusturanKisi;

    @LastModifiedBy
    @Column(insertable = false)
    @JsonIgnore
    private LocalDateTime guncellemeTarihi;

    @LastModifiedBy
    @Column(insertable = false)
    @JsonIgnore
    private String guncelleyenKisi;
}
