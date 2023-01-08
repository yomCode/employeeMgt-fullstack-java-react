package com.aimcodes.employeemanagementbe.entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void createdAt(){
        this.createdAt = new Date();
    }

    @PreUpdate
    public void updatedAt(){
        this.updatedAt = new Date();
    }

}
