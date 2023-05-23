package com.abel.packagetrackingservice.persistence.entity;

import com.abel.packagetrackingservice.enums.PackageState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "packages")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PackageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name="packageId",unique = true, nullable = false, length = 45)
    private String packageId;

    @Column(name="packageName",unique = true, nullable = false, length = 45)
    @NotNull(message = "packageName is required !")
    private String packageName;

    @Column(name="status", nullable = false)
    @NotNull(message = "status is required !")
    private PackageState status;

    @Column(name="last_modified_date",nullable = false)
    @NotNull(message = "status modification date is required !")
    private LocalDateTime lastModifiedDate;//indicates when last the status was updated

    @Column(name="location")
    private String location;


}
