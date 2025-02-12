package br.com.exemplo.api.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.api.modelo.Pessoa;
import br.com.exemplo.api.repositorio.Repositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class Controle {
    
    @GetMapping("")
    public String mensagem(){
        return"Olá, Mundo!";
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return"Bem-Vindo";
    }

     @GetMapping("/boasvindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return"Seja Bem-Vindo(a) "+nome;
    }

     @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p){
        return p;
    }

    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj){
        return acao.save(obj);
    } 
}
    

