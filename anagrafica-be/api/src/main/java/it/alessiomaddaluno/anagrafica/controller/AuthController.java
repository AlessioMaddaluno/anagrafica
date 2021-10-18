package it.alessiomaddaluno.anagrafica.controller;

import it.alessiomaddaluno.anagrafica.dto.SignInDTO;
import it.alessiomaddaluno.anagrafica.dto.SignUpDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import it.alessiomaddaluno.anagrafica.resource.TokenResource;
import it.alessiomaddaluno.anagrafica.resource.UtenteResource;
import it.alessiomaddaluno.anagrafica.security.JwtConfiguration;
import it.alessiomaddaluno.anagrafica.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("accedi")
    ResponseEntity<TokenResource> login(@RequestBody SignInDTO dto, HttpServletResponse request){
        logger.info("[login] START - input: CONFIDENTIAL ");
        String token = this.authService.authenticateUser(dto.getUsername(),dto.getPassword());
        request.setHeader(JwtConfiguration.PARAM,token);
        logger.info("[login] END OK - output: CONFIDENTIAL ");
        return ResponseEntity.ok(new TokenResource(token));
    }

    @PostMapping("registrati")
    ResponseEntity<TokenResource> register(@RequestBody SignUpDTO dto, HttpServletResponse request){
        logger.info("[register] START - input: CONFIDENTIAL ");
        String token = this.authService.registerUser(dto);
        request.setHeader(JwtConfiguration.PARAM,token);
        logger.info("[register] END OK - output: CONFIDENTIAL ");
        return ResponseEntity.ok(new TokenResource(token));
    }

    @GetMapping("me")
    ResponseEntity<UtenteResource> getMe(HttpServletRequest request){
        logger.info("[getMe] START - input: void ");
        String token = request.getHeader(JwtConfiguration.PARAM).split("Bearer ")[1];
        UtenteResource utenteResource = this.authService.getMe(token);
        logger.info("[getMe] END OK - output: {} ",utenteResource);
        return ResponseEntity.ok(utenteResource);
    }
}
