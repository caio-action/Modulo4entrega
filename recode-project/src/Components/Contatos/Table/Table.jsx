/* eslint-disable import/no-anonymous-default-export */
/* eslint-disable jsx-a11y/anchor-is-valid */
import React from "react";
import "./Table.css";

export default () => {
  return (
    <main className="table">
      <div className="tabela-cadastro mt-4 mb-4 table-responsive">
        <table className="table table-sm table-borderless table-hover">
          <thead>
            <tr>
              <th>Nome do cliente</th>
              <th>CPF</th>
              <th>Nº do cartão de crédito</th>
              <th>Telefone</th>
              <th>E-mail</th>
              <th>Destino</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Caio</td>
              <td>99999999999</td>
              <td>99999999999999999</td>
              <td>21 99856 9906</td>
              <td>caiofullstack@gmail.com</td>
              <td>Belo Horizonte</td>
              <td>
                <a className="btn btn-cadastro" role="button" href="#">
                  Editar
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Detalhes
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Apagar
                </a>
              </td>
            </tr>

            <tr>
              <td>Caio</td>
              <td>12345678901</td>
              <td>99999999999999999</td>
              <td>21 99856 9906</td>
              <td>caiofullstack@gmail.com</td>
              <td>Belo Horizonte</td>
              <td>
                <a className="btn btn-cadastro" role="button" href="#">
                  Editar
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Detalhes
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Apagar
                </a>
              </td>
            </tr>
            <tr>
              <td>Caio</td>
              <td>12345678901</td>
              <td>99999999999999999</td>
              <td>21 99856 9906</td>
              <td>caiofullstack@gmail.com</td>
              <td>Belo Horizonte</td>
              <td>
                <a className="btn btn-cadastro" role="button" href="#">
                  Editar
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Detalhes
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Apagar
                </a>
              </td>
            </tr>
            <tr>
              <td>Caio</td>
              <td>12345678901</td>
              <td>99999999999999999</td>
              <td>21 99856 9906</td>
              <td>caiofullstack@gmail.com</td>
              <td>Belo Horizonte</td>
              <td>
                <a className="btn btn-cadastro" role="button" href="#">
                  Editar
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Detalhes
                </a>
                <a className="btn btn-cadastro" role="button" href="#">
                  Apagar
                </a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </main>
  );
};
