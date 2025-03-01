function Formulario({ botao, eventoTeclado, cadastrar, obj, cancelar, deletar, alterar }) {
    return (
        <form>
            <input type="text" value={obj.marca} onChange={eventoTeclado}name="marca" placeholder="Marca" className="form-control" />
            <input type="text" value={obj.modelo} onChange={eventoTeclado}name="modelo" placeholder="Modelo" className="form-control" />
            <input type="number" value={obj.ano} onChange={eventoTeclado}name="ano" placeholder="Ano" className="form-control" />

            {
                botao
                    ?
                    <input type="button" value="Cadastrar" onClick={cadastrar} className="btn btn-primary" />
                    :
                    <div>

                        <input type="button" value="Alterar" onClick={alterar} className="btn btn-warning" />
                        <input type="button" value="Deletar" onClick={deletar} className="btn btn-danger" />
                        <input type="button" value="Cancelar" onClick={cancelar} className="btn btn-secondary" />
                    </div>
            }
        </form>
    )
}

export default Formulario;