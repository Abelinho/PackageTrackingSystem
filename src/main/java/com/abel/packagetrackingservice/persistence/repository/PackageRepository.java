package com.abel.packagetrackingservice.persistence.repository;

import com.abel.packagetrackingservice.persistence.entity.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, Long> {

}
