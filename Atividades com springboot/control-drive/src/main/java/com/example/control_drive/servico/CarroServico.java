package com.example.control_drive.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.control_drive.modelo.CarroModelo;
import com.example.control_drive.modelo.RespostaModelo;
import com.example.control_drive.repositorio.CarroRepositorio;

@Service
public class CarroServico {

    @Autowired
    private CarroRepositorio cr;

    @Autowired
    RespostaModelo rm;

    // método para listar todos os carros
    public Iterable<CarroModelo> listar() {
        return cr.findAll();
    }

    // método para cadastrar ou alterar os carros
    public ResponseEntity<?> cadastrarAlterar(CarroModelo cm, String acao) {
        if (cm.getMarca().equals("")) {
            rm.setMensagem("Marca não pode ser vazia");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (cm.getModelo().equals("")) {
            rm.setMensagem("Modelo não pode ser vazio");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (cm.getAno() == 0) {
            rm.setMensagem("Ano não pode ser vazio ou zero");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                rm.setMensagem("Carro cadastrado com sucesso");
                return new ResponseEntity<CarroModelo>(cr.save(cm), HttpStatus.CREATED);
            } else {
                rm.setMensagem("Carro alterado com sucesso");
                return new ResponseEntity<CarroModelo>(cr.save(cm), HttpStatus.OK);
            }
        }
    }

    // método para excluir um carro
    public ResponseEntity<RespostaModelo> deletar(long codigo) {
        cr.deleteById(codigo);
        rm.setMensagem("Carro deletado com sucesso");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
