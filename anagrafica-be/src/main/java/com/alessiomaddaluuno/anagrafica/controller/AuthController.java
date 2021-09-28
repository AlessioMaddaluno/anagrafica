package com.alessiomaddaluuno.anagrafica.controller;

import com.alessiomaddaluuno.anagrafica.dto.SignInDTO;
import com.alessiomaddaluuno.anagrafica.dto.SignUpDTO;
import com.alessiomaddaluuno.anagrafica.resource.TokenResource;
import com.alessiomaddaluuno.anagrafica.resource.UtenteResource;
import com.alessiomaddaluuno.anagrafica.security.SecurityConfig;
import com.alessiomaddaluuno.anagrafica.service.AuthService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
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
        return ResponseEntity.ok(TokenResource.builder().token(token).build());
    }

    @PostMapping("registrati")
    ResponseEntity<TokenResource> register(@RequestBody SignUpDTO dto,HttpServletResponse request){
        String token = this.authService.registerUser(dto);
        request.setHeader("Authorization",token);
        return ResponseEntity.ok(TokenResource.builder().token(token).build());
    }

    @GetMapping("me")
    ResponseEntity<UtenteResource> getMe(HttpServletRequest request){
        String token = request.getHeader("Authorization").split("Bearer ")[1];
        UtenteResource utenteResource = this.authService.getMe(token);
        return ResponseEntity.ok(utenteResource);
    }
}
