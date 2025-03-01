package com.example.control_drive.controle;

import org.springframework.web.bind.annotation.RestController;

import com.example.control_drive.modelo.CarroModelo;
import com.example.control_drive.modelo.RespostaModelo;
import com.example.control_drive.servico.CarroServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class CarroControle {
    @Autowired
    private CarroServico cs;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody CarroModelo cm) {
        return cs.cadastrarAlterar(cm, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody CarroModelo cm) {
        return cs.cadastrarAlterar(cm, "alterar");
    }

    @GetMapping("/listar")
    public Iterable<CarroModelo> listar() {
        return cs.listar();
    }

    @DeleteMapping("/deletar/{codigo}")
    public ResponseEntity<RespostaModelo> deletar(@PathVariable long codigo) {
        return cs.deletar(codigo);
    }
}
