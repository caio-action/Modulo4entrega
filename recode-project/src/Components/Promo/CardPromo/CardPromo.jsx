/* eslint-disable default-case */
/* eslint-disable import/no-anonymous-default-export */
/* eslint-disable jsx-a11y/anchor-is-valid */
import React, { useState } from "react";
import "./CardPromo.css";

function CardPromo(props) {
  const [num, setNum] = useState(1);

  return (
    <>
      <section className="card-promo font-config">
        <div className="foto-promo">
          <img
            class="img-promo"
            src={props.fotoPromo}
            alt="foto promo"
          />
        </div>
        <section>
          <h3 className="text-center mt-2">{props.destination}</h3>
          <p>Data do Voo: {props.dataVoo.replace("T", " ")}</p>
          <p>Local de embarque: {props.localEmbarque}</p>
        </section>
        <section className="qtdPassagem">
          <span>Nº de passagens: </span>
          <div>
            <button
              className="btn botaoPassagens"
              onClick={() => {
                if (num > 1) setNum(num - 1);
              }}
            >
              -
            </button>
            <span className="mr-1 ml-1">{num}</span>
            <button
              className="btn botaoPassagens"
              onClick={() => setNum(num + 1)}
            >
              +
            </button>
          </div>
        </section>

        <section className="preco">
          <h3>R$ {Number(props.preco).toFixed(2)}</h3>
          <a role="button" href="#">
            Comprar
          </a>
        </section>
      </section>
    </>
  );
}

export default CardPromo;


// return (
//     <>
//       <div className="card-promo font-config">
//         <div className="foto-promo">
//           <img id="bob" src={props.imgPromo} alt="foto promo" />
//         </div>
//         <section>
//           <h3 className="text-center">{props.destination}</h3>
//           <p>Voo dia: {dataVoo}h</p>
//         </section>
//         <section className="qtdPassagem">
//           <span>Nº de passagens: </span>
//           <div>
//             <button
//               className="btn botaoPassagens"
//               onClick={() => {
//                 if (num > 1) setNum(num - 1);
//               }}
//             >
//               -
//             </button>
//             <span className="mr-1 ml-1">{num}</span>
//             <button
//               className="btn botaoPassagens"
//               onClick={() => setNum(num + 1)}
//             >
//               +
//             </button>
//           </div>
//         </section>

//         <section className="preco">
//           <h3>R$ {Number(preco) * num}</h3>
//           <a role="button" href="#">
//             Comprar
//           </a>
//         </section>
//       </div>
//     </>
//   );
  
  // import { React, useState } from "react";
  // import "./CardPromo.css";
  
  // export default (props) => {
  //   let destination = props.destination;
  //   let dataVoo;
  //   let preco;
  
  //   const [num, setNum] = useState(1);
  
  //   switch (destination) {
  //     case "Montevidéo":
  //       dataVoo = "28/03/2022 10:00";
  //       preco = "800.00";
  //       break;
  //     case "Amsterdã":
  //       dataVoo = "29/03/2022 12:00";
  //       preco = "1000.00";
  //       break;
  //     case "Los Angeles":
  //       dataVoo = "30/03/2022 09:00";
  //       preco = "600.00";
  //       break;
  //     case "Santiago":
  //       dataVoo = "02/03/2022 09:30";
  //       preco = "900.00";
  //       break;
  //     case "Lisboa":
  //       dataVoo = "20/03/2022 22:00";
  //       preco = "1000.00";
  //       break;
  //     case "Jamaica":
  //       dataVoo = "27/03/2022 07:45";
  //       preco = "1050.00";
  //       break;
  //   }
