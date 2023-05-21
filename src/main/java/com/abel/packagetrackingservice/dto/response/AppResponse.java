package com.abel.packagetrackingservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppResponse<T>  implements Serializable {

    private String status;

    private Long execTime;

    @Builder.Default
    private Object error = new ArrayList<>();

    private String message;

    private T data;

}
