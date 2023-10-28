package com.barraiser.cleartrip.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
@MappedSuperclass
public class BaseEntity {

    @Id
    private Long id;

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    @PrePersist
    private void prePersist() {
        createdAt = ZonedDateTime.now();
        updatedAt = ZonedDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        updatedAt = ZonedDateTime.now();
    }
}
