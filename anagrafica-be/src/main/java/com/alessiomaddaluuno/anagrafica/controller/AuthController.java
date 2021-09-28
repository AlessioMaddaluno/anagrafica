package com.alessiomaddaluuno.anagrafica.controller;

import com.alessiomaddaluuno.anagrafica.dto.SignInDTO;
import com.alessiomaddaluuno.anagrafica.dto.SignUpDTO;
import com.alessiomaddaluuno.anagrafica.resource.TokenResource;
import com.alessiomaddaluuno.anagrafica.resource.UtenteResource;
import com.alessiomaddaluuno.anagrafica.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("accedi")
    ResponseEntity<TokenResource> login(@RequestBody SignInDTO dto, HttpServletResponse request){
        String token = this.authService.authenticateUser(dto.getUsername(),dto.getPassword());
        request.setHeader("Authorization",token);
        return ResponseEntity.ok(new TokenResource(token));
    }

    @PostMapping("registrati")
    ResponseEntity<TokenResource> register(@RequestBody SignUpDTO dto,HttpServletResponse request){
        String token = this.authService.registerUser(dto);
        request.setHeader("Authorization",token);
        return ResponseEntity.ok(new TokenResource(token));
    }

    @GetMapping("me")
    ResponseEntity<UtenteResource> getMe(HttpServletRequest request){
        String token = request.getHeader("Authorization").split("Bearer ")[1];
        UtenteResource utenteResource = this.authService.getMe(token);
        return ResponseEntity.ok(utenteResource);
    }
}
