package com.abel.packagetrackingservice.controller;

import com.abel.packagetrackingservice.dto.request.PackageRequest;
import com.abel.packagetrackingservice.dto.response.AppResponse;
import com.abel.packagetrackingservice.dto.response.PackageResponse;
import com.abel.packagetrackingservice.service.PackageService;
import com.sun.deploy.association.utility.AppUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class PackageController {

    private final PackageService packageService;

    @PostMapping(value = "/packages", produces = "Application/json", consumes = "Application/json")
    public ResponseEntity<PackageResponse> createPackage(@Valid @RequestBody PackageRequest request){

        //to do: //sanitize the request to prevent HTML injection
        //to do: call service
        PackageResponse packageResponse = packageService.createPackage(request);

        return ResponseEntity.ok().body(packageResponse);
    }

    @GetMapping(value = "/packages/{id}")
    public ResponseEntity<PackageResponse> getPackageById(@PathVariable("id") String id){

        PackageResponse packageResponse = packageService.getPackageById(id);

        return ResponseEntity.ok().body(packageResponse);

    }

    @GetMapping(value = "/packages")
    public ResponseEntity<List<PackageResponse>> getAllPackages(@RequestParam(value = "page", defaultValue = "0") int page,
                                                               @RequestParam(value = "limit", defaultValue = "2") int limit){

        List<PackageResponse> clientsList = packageService.getAllPackage(page,limit);

        return ResponseEntity.ok().body(clientsList);
    }

   //to do: implement update and Delete package endppoints
    // It’s possible for a package to be IN_TRANSIT,
    // and WAREHOUSE multiple times but it’s not possible to be PICKED_UP and DELIVERED more than once.
    //check the status of a package BEFORE updating it!

    @PutMapping(value = "/packages", produces = "Application/json", consumes = "Application/json")
    public ResponseEntity<PackageResponse> updatePackage(@Valid @RequestBody PackageRequest request){

        //sanitise the request to prevent HTML injection!!!
        //call the service
        PackageResponse clientResponse = packageService.updatePackage(request);

        return ResponseEntity.ok().body(clientResponse);
    }

    @DeleteMapping(value = "/packages/{id}")
    public ResponseEntity<PackageResponse> deletePackage(@PathVariable("id") String id){

        PackageResponse packageResponse = packageService.deletePackage(id);

        return ResponseEntity.ok().body(packageResponse);

    }

}
