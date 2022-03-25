/* eslint-disable import/no-anonymous-default-export */
import React, { useEffect, useState } from "react";
import "./CadastroMensagens.css";

import { getContatos, deleteContato } from "../../../service/ContatoService";
import Header from "../../../Components/Header/Header";

export default () => {
  const [mensagem, setMensagem] = useState([]);

  useEffect(() => {
    getContatos()
      .then((res) => setMensagem(res))
      .catch((erro) => console.log(erro));
  }, []);

  function apagarMensagem(id) {
    deleteContato(id)
      .then(
        getContatos()
          .then((res) => setMensagem(res))
          .then(() => window.location.reload())
      )
      .catch((erro) => console.log(erro));
  }

  return (
    <>
      <main>
        <Header/>
      </main>
      <h1 className="text-center">Mensagens</h1>

      <section className="mensagem">
        {mensagem.map((mensagem) => (
          <div className="mt-5 mb-5 container-mensagem" key={mensagem.id}>
            <div className="div-button-delete mb-1">
              <button
                className="button-delete"
                onClick={() => apagarMensagem(mensagem.id)}
              >
                <i className="bi bi-trash"> Excluir mensagem</i>
              </button>
            </div>

            <h3 className="text-center">
              <i class="bi bi-envelope"></i>
            </h3>
            <span className="mb-1">Nome: {mensagem.nome}</span>
            <span className="mb-1">Email: {mensagem.email}</span>
            <span>Assunto:</span>
            <span className="mb-1">{mensagem.assunto}</span>
            <span className="text-center">Mensagem:</span>
            <p>{mensagem.mensagem}</p>
          </div>
        ))}
      </section>
    </>
  );
};
