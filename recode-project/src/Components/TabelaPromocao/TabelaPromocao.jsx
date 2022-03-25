import React from "react";
import { useEffect,useState } from "react";

import { deletarPromocao, getPromocoes } from "../../service/PromocaoService";



export default () => {

  const [promo, setPromocao] = useState([])
  
  

  useEffect(() => {getPromocoes().then((res) => setPromocao(res)).catch((erro) => console.log(erro))},[])

  function deletar(id) {
    deletarPromocao(id).then(getPromocoes().then((res) => setPromocao(res)).then(() => window.location.reload())).catch((erro) => console.log(erro))
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
                        Preço
                    </th>
                    
                    <th>
                        Data de embarque
                    </th>
                    <th>

                    </th>
                </tr>
            </thead>
            <tbody>
              {promo.map((promo) => (
                <tr key={promo.idPromo}>
                  <td>
                      {promo.destino.nomeDestino}
                  </td>
                  <td>
                      {promo.localPartida}
                  </td>
                  <td>
                      {promo.precoPromo}
                  </td>
              
                  <td>
                      {promo.data.replace('T', ' ')}
                  </td>
                  <td>
                    <button className="btn btn-cadastro" onClick={() => deletar(promo.idPromo)}>Excluir</button>
                  </td>
              
                 </tr>
              ))}
              

            </tbody>
        </table>
    
      </div>
  );
}