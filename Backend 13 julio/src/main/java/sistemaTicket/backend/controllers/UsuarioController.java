package sistemaTicket.backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sistemaTicket.backend.entities.UsuarioEntity;
import sistemaTicket.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173") // para realizar las peticiones

@RestController
public class UsuarioController{
    @Autowired
    UsuarioService usuarioService;

    @PostMapping(value = "/usuario/")
    public ResponseEntity<UsuarioEntity> guardar(@RequestBody UsuarioEntity usuarioEntityNuevo) {
        UsuarioEntity objeto = usuarioService.guardar(usuarioEntityNuevo);
        return new ResponseEntity<UsuarioEntity>(objeto, HttpStatus.OK);
    }

    @GetMapping("/usuarios/")
    public Iterable<UsuarioEntity> todos() {
        return usuarioService.todos();
    }

    @GetMapping("/usuario/{id}")
    public Optional<UsuarioEntity> obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuario(id);
    }

}

