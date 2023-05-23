package com.abel.packagetrackingservice.dto.request;

import com.abel.packagetrackingservice.enums.PackageState;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PackageRequest {

    private String packageId;

    //@Schema(required=true) add swagger!
    @NotEmpty(message = "packageName cannot be empty")
    @JsonProperty("packageName")
    private String packageName;

    @NotNull(message = "Status must not be null")
    private PackageState status;

    @NotNull(message = "lastModifiedDate must not be null")
    private LocalDateTime lastModifiedDate;

    private String location;


}
