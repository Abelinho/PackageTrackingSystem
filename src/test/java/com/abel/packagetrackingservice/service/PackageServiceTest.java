package com.abel.packagetrackingservice.service;

import com.abel.packagetrackingservice.core.exception.PackageNotFoundException;
import com.abel.packagetrackingservice.dto.request.PackageRequest;
import com.abel.packagetrackingservice.dto.response.PackageResponse;
import com.abel.packagetrackingservice.enums.PackageState;
import com.abel.packagetrackingservice.persistence.entity.PackageEntity;
import com.abel.packagetrackingservice.persistence.repository.PackageRepository;
import com.abel.packagetrackingservice.util.AppUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class PackageServiceTest {

    @InjectMocks
    PackageService packageService;//class under test

    @Mock
    PackageRepository packageRepository;
    @Mock
    AppUtil appUtil;

    private PackageEntity packageEntity;
    private PackageResponse packageResponse;
    private PackageRequest packageRequest;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this); // .initMocks();

        packageEntity = new PackageEntity();
        packageEntity.setId(1L);
        packageEntity.setPackageName("AbeliPackage");
        packageEntity.setLocation("Lagos");
        packageEntity.setStatus(PackageState.PICKED_UP);
        packageEntity.setPackageId("testpackage");

        packageResponse = PackageResponse.builder()
                .packageId("testpackage")
                .location("Lagos")
                .packageName("AbeliPackage")
                .status(PackageState.PICKED_UP)
                .build();

         packageRequest = new PackageRequest();

        packageRequest.setPackageName("AbeliPackage");
        packageRequest.setLocation("Lagos");
        packageRequest.setPackageId("testpackage");
        packageRequest.setStatus(PackageState.PICKED_UP);



    }

    @Test
    void testCreatePackage() {

        when(appUtil.generatePackageId(anyInt())).thenReturn("testPackageId");
        when(packageRepository.save(any(PackageEntity.class))).thenReturn(packageEntity);

        PackageResponse packageResponse = packageService.createPackage(packageRequest);

        assertNotNull(packageResponse);

        assertEquals("Lagos", packageResponse.getLocation());

    }

    @Test
    void getAllPackage() { //not implemented for lack of time :(

        //when(packageRepository.findAll()).thenReturn();

    }

    @Test
    void testGetPackageById() {

        when(packageRepository.findByPackageId(anyString())).thenReturn(packageEntity);

        PackageResponse packageResponse = packageService.getPackageById("testId");

        assertNotNull(packageResponse);
        assertEquals("Lagos", packageResponse.getLocation());
    }


    @Test
    final void testGetPackageById_PackageNotFoundException() {
        when(packageRepository.findByPackageId(anyString())).thenReturn(null);

        assertThrows(PackageNotFoundException.class,

                () -> {
                    packageService.getPackageById("testId");
                }

        );
    }

    @Test
    void updatePackage() { //not implemented for lack of time :(
    }

    @Test
    void deletePackage() { //not implemented for lack of time :(
    }
}