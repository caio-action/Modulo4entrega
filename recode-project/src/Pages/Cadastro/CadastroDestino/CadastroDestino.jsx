/* eslint-disable import/no-anonymous-default-export */
import React from "react";
import Header from "../../../Components/Header/Header";
import "./CadastroDestino.css";
import TabelaCadastro from "../../../Components/TabelaCadastro/TabelaCadastro";
import FormCadastroDestino from "../../../Components/FormCadastroDestino/FormCadastroDestino";
import Footer from "../../../Components/Footer/Footer";

export default () => {
  return (
    <main className="container-cadastro-destino">
      <Header />
      <FormCadastroDestino titulo="Cadastrar " />
      
      <Footer />
    </main>
  );
};
