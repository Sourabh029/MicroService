package com.soudivs.Pooduct.Service.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {

    private String message;
    private Date timestamp;
    private Boolean status;
}
