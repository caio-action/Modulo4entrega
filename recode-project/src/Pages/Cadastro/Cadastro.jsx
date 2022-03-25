/* eslint-disable import/no-anonymous-default-export */
import React from "react";
import "./Cadastro.css";
import { Link } from "react-router-dom";
import Header from "../../Components/Header/Header";
import Footer from "../../Components/Footer/Footer";

export default () => {
  return (
    <>
        <Header/>
      <main className="container-cadastro">
        <Link to={"/Cadastro/CadastroDestino"}>
          <button>Cadastro destinos</button>
        </Link>

        <Link to={"/Cadastro/CadastroPromocao"}>
          <button>Cadastro promoções</button>
        </Link>

        <Link to={"/Cadastro/CadastroMensagem"}>
          <button>Mensagens</button>
        </Link>
      </main>
      <Footer></Footer>
    </>
  );
};
