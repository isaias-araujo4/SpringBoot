package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.produtomodelo;
import br.com.api.produtos.modelo.respostamodelo;
import br.com.api.produtos.servico.produtoservico;

@RestController
@CrossOrigin(origins = "*")
public class produtocontrole {
    @Autowired

    private produtoservico ps;

    //rota para cadastrar
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody produtomodelo pm){
        return ps.cadastraralterar(pm, "cadastrar");
    }

    //rota para alterar
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody produtomodelo pm){
        return ps.cadastraralterar(pm, "alterar");
    }

    //rota para listar
    @GetMapping("/listar")
    public Iterable<produtomodelo> listar(){
        return ps.Listar();
    }

    //rota para excluir
    @DeleteMapping("/remover/{codigo}")
    public ResponseEntity<respostamodelo> remover(@PathVariable long codigo){
        return ps.remover(codigo);
    }

    //rotya inicial
    @GetMapping("")
    public String rota (){
        return "api funcionando";
    }
}
