package com.abel.packagetrackingservice.service;

import com.abel.packagetrackingservice.dto.request.PackageRequest;
import com.abel.packagetrackingservice.dto.response.PackageResponse;
import com.abel.packagetrackingservice.persistence.entity.PackageEntity;
import com.abel.packagetrackingservice.persistence.repository.PackageRepository;
import com.abel.packagetrackingservice.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PackageService {

   private final PackageRepository packageRepository;

   private final AppUtil appUtil;

    public PackageResponse createPackage(PackageRequest request) {



        PackageEntity packageEntity = new PackageEntity();
        packageEntity.setPackageId(appUtil.generateUserId(5));
        packageEntity.setPackageName(request.getPackageName());
        packageEntity.setLocation(request.getLocation());
        packageEntity.setLastModifiedDate(request.getLastModifiedDate());
        packageEntity.setStatus(request.getStatus());

        //call the repository
        PackageEntity savedPackageEntity = packageRepository.save(packageEntity);

       return PackageResponse.builder()
                .packageId(savedPackageEntity.getPackageId())
                .lastModifiedDate(savedPackageEntity.getLastModifiedDate())
                .location(savedPackageEntity.getLocation())
                .packageName(savedPackageEntity.getPackageName())
                .status(savedPackageEntity.getStatus())
                .build();

    }

    public List<PackageResponse> getAllPackage(int page, int limit) {

        List<PackageResponse> returnValue = new ArrayList<>();

        if(page>0) page = page-1;

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<PackageEntity> packagePage = packageRepository.findAll(pageableRequest);

        List<PackageEntity> returnedPackages = packagePage.getContent();

        PackageResponse packageResponse;

        for (PackageEntity packages : returnedPackages) {
            packageResponse = PackageResponse.builder()
                    .packageId(packages.getPackageId())
                    .status(packages.getStatus())
                    .packageName(packages.getPackageName())
                    .location(packages.getLocation())
                    .lastModifiedDate(packages.getLastModifiedDate())
                    .build();

            returnValue.add(packageResponse);
        }

        return returnValue;
    }
}
