import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './formulario';
import Tabela from './tabela';

function App() {
  //objeto carro
  const carro = {
    codigo: 0,
    marca: "",
    modelo: "",
    ano: 0
  }

  const [btnCadastrar, setBtnCadastrar] = useState(true);
  const [carros, setCarros] = useState([]);
  const [objcarro, setObjcarro] = useState(carro);

  useEffect(() => {
    fetch("http://localhost:8080/listar")
      .then(retorno => retorno.json())
      .then(retorno_convertido => setCarros(retorno_convertido));
  }, []);

  const aoDigitar = (e) => {
    setObjcarro({
      ...objcarro,
      [e.target.name]: e.target.value
    });
  }

  //cadastrar carro
  const cadastrar = () => {
    fetch("http://localhost:8080/cadastrar", {
      method: "POST",
      body: JSON.stringify(objcarro),
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      }
    })
      .then(retorno => retorno.json())
      .then(retorno_convertido => {
        if (retorno_convertido.menssagem !== undefined) {
          alert(retorno_convertido.menssagem);
        } else {
          setCarros([...carros, retorno_convertido]);
          alert("Carro cadastrado com sucesso!")
          limparFormulario();
        }
      })
  }

  //limpar formulário
  const limparFormulario = () => {
    setObjcarro(carro);
    setBtnCadastrar(true);
  }

  //selecionar carro
  const selecionarCarro = (indice) => {
    setObjcarro(carros[indice]);
    setBtnCadastrar(false);
  }

  //deletar carro
  const deletar = () => {
    fetch("http://localhost:8080/deletar/" + objcarro.codigo, {
      method: "delete",

      headers: {
        "Content-type": "application/json",
        "Accept": "application/json"
      }
    })
      .then(retorno => retorno.json())
      .then(retorno_convertido => {

        //mensagem
        alert(retorno_convertido.mensagem)

        //cópia de vetor carros
        let vetorTemp = [...carros];

        //indice
        let indice = vetorTemp.findIndex((p) => {
          return p.codigo === objcarro.codigo;
        });

        //deletar carro do vetor
        vetorTemp.splice(indice, 1);

        //atualizar o vetor de carro
        setCarros(vetorTemp);

        //limpar formulário
        limparFormulario();

      })
  }

  //alterar carro
  const alterar = () => {
    fetch("http://localhost:8080/alterar", {
      method: "put",
      body: JSON.stringify(objcarro),
      headers: {
        "Content-type": "application/json",
        "Accept": "application/json"
      }
    })
      .then(retorno => retorno.json())
      .then(retorno_convertido => {
        if (retorno_convertido.mensagem !== undefined) {
          alert(retorno_convertido.menssagem);
        } else {
          //mensagem
          alert("Carro alterado com sucesso!");

          //cópia de vetor de carros
          let vetorTemp = [...carros];

          //indice
          let indice = vetorTemp.findIndex((p) => {
            return p.codigo === objcarro.codigo;
          });
          //alterar carro de vetor
          vetorTemp[indice] = objcarro;

          //atualizar o vetor de carros
          setCarros(vetorTemp);

          //limpar formulário
          limparFormulario();
        }
      })
  }

  return (
    <div>
      <Formulario botao={btnCadastrar} eventoTeclado={aoDigitar} cadastrar={cadastrar} obj={objcarro} cancelar={limparFormulario} deletar={deletar} alterar={alterar}/>
      <Tabela vetor={carros} selecionar={selecionarCarro} />
    </div>
  );
}

export default App;
