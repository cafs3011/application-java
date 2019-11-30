package com.br.codenation.application.controller;
import com.br.codenation.application.domain.vo.EmpresaVO;
import com.br.codenation.application.domain.vo.UsuarioVO;
import com.br.codenation.application.service.impl.UsuarioServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioService;
    private Logger LOG = LoggerFactory.getLogger(EmpresaController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity create(@RequestBody UsuarioVO usuario) {
        try {
            return ResponseEntity.ok().body(usuarioService.create(usuario));
        } catch (Exception exception) {
            LOG.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity changeSalario(@RequestBody UsuarioVO usuario) {
        try {
            return ResponseEntity.ok(usuarioService.changeSalario(usuario));
        } catch (Exception exception) {
            LOG.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

}