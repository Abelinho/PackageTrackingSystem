package com.abel.packagetrackingservice.dto.request;

import com.abel.packagetrackingservice.PackageState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageRequest {

    private String packageId;

    //@Schema(required=true) add swagger!
    @NotEmpty(message = "packageName cannot be empty")
    @JsonProperty("packageName")
    private String packageName;

    @NotEmpty(message = "status cannot be empty")
    private PackageState status;

    @NotEmpty(message = "lastModifiedDate cannot be empty")
    private LocalDateTime lastModifiedDate;

    private String location;


}
