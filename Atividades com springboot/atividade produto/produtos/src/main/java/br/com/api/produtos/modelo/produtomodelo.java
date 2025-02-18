package br.com.api.produtos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="produtos")
@Getter
@Setter
public class produtomodelo {
    @Id
    @GeneratedValue
    private long codigo;
    private String nome;
    private String marca;
}
