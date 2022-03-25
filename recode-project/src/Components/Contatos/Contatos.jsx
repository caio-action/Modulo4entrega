/* eslint-disable import/no-anonymous-default-export */
import React , {  useRef }from "react";
// import Actions from "../Actions/Actions";
// import Table from "./Table/Table";
import { postContato } from "./../../service/ContatoService";

export default () => {
const nome = useRef();
const email = useRef();
const assunto = useRef();
const mensagem = useRef();
  
function enviarMensagem(event) {
  event.preventDefault();
  const contato = {
    email: email.current.value,
    nome: nome.current.value,
    assunto: assunto.current.value,
    mensagem: mensagem.current.value,
  };
  postContato(contato)
    .then(() => window.location.reload())
    .catch((err) => console.log(err));
  alert("Mensagem enviada!");
}
  
return(
<main className="table">
      <h1 className="text-center">Fale conosco</h1>

      <section className="container mt-3 section-contatos">
        <form className="form-contato" onSubmit={enviarMensagem}>
          <div className="form-group">
            <label for="nome">Seu nome:</label>
            <input
              type="text"
              className="form-control"
              id="nome"
              placeholder="digite seu nome"
              maxLength={50}
              required
              ref={nome}
            />
          </div>
          <div className="form-group">
            <label for="email">Endereço de email:</label>
            <input
              type="email"
              className="form-control"
              id="email"
              placeholder="nome@exemplo.com"
              maxLength={70}
              required
              ref={email}
            />
          </div>
          <div className="form-group">
            <label for="assunto">Assunto:</label>
            <select
              className="form-control"
              id="assunto"
              maxLength={500}
              required
              ref={assunto}
            >
              <option>Assunto</option>
              <option>Texto exemplo</option>
              <option>Texto exemplo</option>
              <option>Texto exemplo</option>
              <option>Texto exemplo</option>
            </select>
          </div>

          <div className="form-group">
            <label for="mensagem">Mensagem:</label>
            <textarea
              className="form-control"
              id="mensagem"
              rows="5"
              ref={mensagem}
              required
            ></textarea>
          </div>
          <button type="submit" className="btn btn-form-contato">
            Enviar mensagem
          </button>
        </form>
      </section>
    </main>
  );
};
 

// return (
  //   <main className="mt-1 pb-3">
  //     <Actions
  //       titulo={"Cadastro de Clientes"}
  //       nomeBotao={"Adicionar cliente"}
  //     />

  //     <Table />
  //   </main>
  // );

