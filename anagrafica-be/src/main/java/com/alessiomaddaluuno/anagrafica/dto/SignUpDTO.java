package com.alessiomaddaluuno.anagrafica.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class SignUpDTO {

    private String username;
    private String password;

}
