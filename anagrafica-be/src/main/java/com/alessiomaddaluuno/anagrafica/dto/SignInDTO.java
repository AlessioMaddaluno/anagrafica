package com.alessiomaddaluuno.anagrafica.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignInDTO {
    private String username;
    private String password;
}
