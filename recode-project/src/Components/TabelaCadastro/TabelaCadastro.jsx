import React from "react";
import { useEffect,useState } from "react";

import { deletarDestino } from "../../service/DestinoServices";
import { getDestinos } from "../../service/DestinoServices";


export default () => {

  const [destino, setDestino] = useState([])
  
  

  useEffect(() => {getDestinos().
  then((res) => setDestino(res)).catch((erro) => console.log(erro))},[])

  function deletar(id) {
    deletarDestino(id).then(getDestinos().then((res) => setDestino(res)).then(() => window.location.reload())).catch((erro) => console.log(erro))
  }

  return(
      <div className="tabela-cadastro mt-4 mb-4 table-responsive">

        <table className="table table-sm table-borderless table-hover">
            <thead>
                <tr>
                    <th>
                        Destino
                    </th>
                    <th>
                        Descrição
                    </th>
                    <th>
                        Url da foto
                    </th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
              {destino.map((destino) => (
                <tr key={destino.idDestino}>
                  <td>
                      {destino.nomeDestino}
                  </td>
                  <td>
                      {destino.descricao}
                  </td>
                  <td>
                      {destino.foto}
                  </td>
                  <td>
                    <button className="btn btn-cadastro" onClick={() => deletar(destino.idDestino)}>Excluir</button>
                  </td>
              
                 </tr>
              ))}
              

            </tbody>
        </table>
    
      </div>
  );
}