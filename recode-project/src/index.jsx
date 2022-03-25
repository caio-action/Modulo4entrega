import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import Home from "./Pages/Home/Home";
import Promocoes from "./Pages/Promoções/Promocoes";
import Destinos from "./Pages/Destinos/Destinos";
import Contatos from "./Pages/Contatos/Contatos";
import CadastroDestino from "./Pages/Cadastro/CadastroDestino/CadastroDestino";
import CadastroPromocao from "./Pages/Cadastro/CadastroPromocao/CadastroPromocao";
import Cadastro from "./Pages/Cadastro/Cadastro"
import CadastroMensagens from "./Pages/Cadastro/CadastroMensagens/CadastroMensagens";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./redux/index";
ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <Router>
        <Routes>
          <Route path="/" exact element={<Home />}></Route>
          <Route path="/Promocoes" element={<Promocoes />}></Route>
          <Route path="/Destinos" element={<Destinos />}></Route>
          <Route path="/Contatos" element={<Contatos />}></Route>
          <Route path="/Cadastro" element={<Cadastro />}></Route>
          <Route path="/Cadastro/CadastroDestino" element={<CadastroDestino />}></Route>
          <Route path="/Cadastro/CadastroPromocao" element={<CadastroPromocao />}></Route>
          <Route path="/Cadastro/CadastroMensagem" element={<CadastroMensagens />}></Route>
          {/* <Route path='/Actions' element={<Actions/>}></Route>
      <Route path='/Table' element={<Table/>}></Route> */}
        </Routes>
      </Router>
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
