package br.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.produtos.modelo.produtomodelo;
import br.com.api.produtos.modelo.respostamodelo;
import br.com.api.produtos.repositorio.produtorepositorio;

@Service
public class produtoservico {
    @Autowired
    private produtorepositorio pr;
    @Autowired
    private respostamodelo rm;

    //método para cadastrar/alterar produto
    public ResponseEntity<?> cadastraralterar (produtomodelo pm, String acao){
        if (pm.getNome().equals("")) {
            rm.setMensagem("O nome é obrigatorio");
            return new ResponseEntity<respostamodelo>(rm,HttpStatus.BAD_REQUEST);
        }else if (pm.getMarca().equals("")) {
            rm.setMensagem("O nome da marca é obrigatorio");
            return new ResponseEntity<respostamodelo>(rm,HttpStatus.BAD_REQUEST);
        }else if (acao.equals("cadastrar")) {
            return new ResponseEntity<produtomodelo>(pr.save(pm), HttpStatus.CREATED);      
        }else{
            return new ResponseEntity<produtomodelo>(pr.save(pm), HttpStatus.OK);
        }
        
    }

    // método para listas os produtos
    public Iterable<produtomodelo> Listar(){
        return pr.findAll();
    }

    //metodo para excluir produto
    public ResponseEntity<respostamodelo> remover(long codigo){
        pr.deleteById(codigo);

        rm.setMensagem("O produto foi removido");
        return new ResponseEntity<respostamodelo>(rm,HttpStatus.OK);
    }
}
