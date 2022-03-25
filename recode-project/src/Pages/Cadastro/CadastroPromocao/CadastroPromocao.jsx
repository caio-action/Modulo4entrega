/* eslint-disable import/no-anonymous-default-export */
import React from "react";
import './CadastroPromocao.css';
import TabelaPromocao from "../../../Components/TabelaPromocao/TabelaPromocao";
import FormCadastroPromocao from "../../../Components/FormCadastroPromocao/FormCadastroPromocao";
import Footer from '../../../Components/Footer/Footer';
import Header from "../../../Components/Header/Header";

export default () => {

  return(
    <>
      <main className="container-cadastro-destino">
      <Header/>
        <FormCadastroPromocao titulo="Promoções"/>
        <TabelaPromocao/>
        <Footer/>
      </main>

      

    </>
  );
}