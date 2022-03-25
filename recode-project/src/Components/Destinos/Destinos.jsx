import React, { useEffect, useState } from "react";
// import Actions from "../Actions/Actions";
// import Table from "./Table/Table";
import { Link } from "react-router-dom";
import { getDestinos } from "./../../service/DestinoServices";

function Destinos() {
  const [destino, setDestino] = useState([]);

  useEffect(() => {
    getDestinos()
      .then((goal) => setDestino(goal))
      .catch((erro) => console.log(erro));
  }, []);

  return (
    <main className="pb-3 mt-2 font-config">
      <h1 className="font-config text-center">Nossos Destinos</h1>

      {destino.map((destino) => (
        <section
          className="card-destination container mt-5"
          key={destino.idDestino}
        >
          <div className="row align-items-center">
            <div className="col-md-6 destino-foto">
              <Link to={"/destinos"}>
                <img src={destino.foto} alt={`Foto ${destino.nomeDestino}`} />
              </Link>
            </div>

            <div className="col-md-6 destino-texto">
              <h4 className="text-center mb-2">{destino.nomeDestino}</h4>
              <p className="text-center">{destino.txt}</p>
            </div>
          </div>
        </section>
      ))}
    </main>
  );
}
export default Destinos;
// export default Maindestination

// export default () => {
//   return(
//     <main class="pb-3 mt-1">
//       <Actions titulo={"Cadastro de Destinos"} nomeBotao={"Adicionar novo destino"}/>

//       <Table/>
//     </main>
//   );
// }//
