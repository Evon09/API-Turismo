package br.edu.utfpr.turismoapi.controllers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.turismoapi.dto.AuthDTO;
import br.edu.utfpr.turismoapi.security.JwtUtil;
import jakarta.validation.Valid;

@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    public ResponseEntity<Object> auth(@Valid @RequestBody AuthDTO authDTO) {
        System.out.println(authDTO);

        // dados do payload
        var payload = new HashMap<String, Object>();
        payload.put("username", authDTO.getUsername());

        var now = Instant.now();

        var jwt = jwtUtil.generateToken(payload, "1234", 3600);

        var res = new HashMap<String, Object>();
        res.put("token", jwt);
        res.put("issuedIn", now);
        res.put("expiresIn", now.plus(3600, ChronoUnit.SECONDS));
        return ResponseEntity.ok().body(res);
    }
}