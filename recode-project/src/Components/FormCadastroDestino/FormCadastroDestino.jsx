/* eslint-disable import/no-anonymous-default-export */
import React, { useRef } from "react";
import { postDestino } from "../../service/DestinoServices";

export default (props) => {
  const nome = useRef();
  const descricao = useRef();
  const foto = useRef();

  function postarDestino(event) {
    event.preventDefault();
    const destino = {
      nomeDestino: nome.current.value,
      descricao: descricao.current.value,
      foto: foto.current.value,
    };
    postDestino(destino)
      .then(() => window.location.reload())
      .catch((erro) => console.log(erro));
  }

  return (
    <section className="container-fluid mb-2">
      <h1 className="font-config">{props.titulo}</h1>

      <form onSubmit={postarDestino}>
        <div className="form-group">
          <label for="exampleFormControlInput1">Destino:</label>
          <input
            type="text"
            className="form-control"
            id="exampleFormControlInput1"
            ref={nome}
          />
        </div>
        <div className="form-group">
          <label for="exampleFormControlInput2">Sobre:</label>
          <input
            type="text"
            className="form-control"
            id="exampleFormControlInput2"
            ref={descricao}
          />
        </div>
        <div className="form-group">
          <label for="exampleFormControlInput3">foto destino:</label>
          <input
            type="text"
            className="form-control"
            id="exampleFormControlInput3"
            ref={foto}
          />
        </div>
        <button type="submit" className="btn btn-cadastro">
          Cadastrar
        </button>
      </form>
    </section>
  );
};
