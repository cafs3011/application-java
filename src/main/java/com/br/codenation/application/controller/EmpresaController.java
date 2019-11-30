package com.br.codenation.application.controller;

import com.br.codenation.application.domain.vo.EmpresaVO;
import com.br.codenation.application.service.impl.EmpresaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Controller de empresas")
@RestController
@RequestMapping("/v1/empresas")
public class EmpresaController {

    @Autowired
    EmpresaServiceImpl empresaService;
    private Logger LOG = LoggerFactory.getLogger(EmpresaController.class);


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Metódo de criação da empresa")
    @ApiResponses(value={
            @ApiResponse(code=200, message="Sucessfully retrieved list")
    })
    public ResponseEntity create(@RequestBody EmpresaVO empresa) {
        try {
            return ResponseEntity.ok().body(empresaService.create(empresa));
        } catch (Exception exception) {
            LOG.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

        @GetMapping
        public ResponseEntity findByName(@RequestParam String nome){
            try {
                return ResponseEntity.ok(empresaService.findByName(nome));
            } catch (Exception exception) {
                LOG.error(exception.getMessage());
                return ResponseEntity.badRequest().body(exception.getMessage());
            }
        }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            empresaService.delete(id);
            return ResponseEntity.ok("Delete com sucesso!");
        }catch (EmptyResultDataAccessException exception) {
            LOG.error(exception.getMessage());
            return ResponseEntity.notFound().build();
        }
        catch (Exception exception) {
            LOG.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED     )
    public ResponseEntity changeSalario(@RequestBody EmpresaVO empresa) {
        try {
            return ResponseEntity.ok(empresaService.changeVagas(empresa));
        } catch (Exception exception) {
            LOG.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/averageSalary")
    public ResponseEntity getAverageSalary(){
        try {
            return ResponseEntity.ok(empresaService.getAverageSalary());
        } catch (Exception exception) {
            LOG.error(exception.getMessage());
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}



