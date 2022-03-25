/* eslint-disable import/no-anonymous-default-export */
import React, { useEffect, useState } from "react";
import "./Actions.css";
import { deletarDestino, getDestinos } from "../../service/DestinoServices";

export default () => {
  const [destino, setDestino] = useState([]);
  useEffect(() => {
    getDestinos()
      .then((res) => setDestino(res))
      .catch((erro) => console.log(erro));
  }, []);
  function deletar(id) {
    deletarDestino(id)
      .then(
        getDestinos()
          .then((res) => setDestino(res))
          .then(() => window.location.reload())
      )
      .catch((erro) => console.log(erro));
  }

  return (
    <div className="tabela-cadastro mt-4 mb-4 table-responsive">
      <table className="table table-sm table-borderless table-hover">
        <thead>
          <tr>
            <th>Destino</th>
            <th>Sobre</th>
            <th>foto</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {destino.map(() => (
            <tr key={destino.idDestino}>
              <td>{destino.nomeDestino}</td>
              <td>{destino.txt}</td>
              <td>{destino.foto}</td>
              <td>
                <button
                  className="btn btn-cadastro"
                  onClick={() => deletar(destino.idDestino)}
                >
                  Excluir
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

//   return (

//     <section className="container-fluid mb-2">
//       <h1 className="title-container">{props.titulo}</h1>

//       <p>
//         <a className="btn btn-cadastro" role="button" href="#">
//           {props.nomeBotao}
//         </a>
//       </p>
//     </section>
//   );
// };
