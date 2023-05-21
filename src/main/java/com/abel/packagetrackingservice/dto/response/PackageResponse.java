package com.abel.packagetrackingservice.dto.response;

import com.abel.packagetrackingservice.PackageState;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PackageResponse implements Serializable {

    private String packageId;

    private String packageName;

    private PackageState status;

    private LocalDateTime lastModifiedDate;//indicates when last the status was updated

    private String location;

}
