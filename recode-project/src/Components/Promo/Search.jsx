import React, { useEffect, useRef, useState } from "react";
import { getDestinos } from "../../../src/service/DestinoServices";

import { connect } from "react-redux";

function Search({ dispatch }) {
  const [destino, setDestino] = useState([]);
  const inputSearch = useRef();

  function selecionarDestino() {
    const value = inputSearch.current.value;
    console.log(value);

    return {
      type: "PUT",
      choose: value,
    };
  }

  useEffect(() => {
    getDestinos()
      .then((res) => setDestino(res))
      .catch((erro) => console.log(erro));
  }, []);

  return (
    <select
      onChange={() => dispatch(selecionarDestino())}
      className="input-Search mt-3 mb-1"
      ref={inputSearch}
    >
      <option className="text-center" value="Promoções">
        Promoções
      </option>
      {destino.map((destino) => (
        <option className="text-center" value={destino.nomeDestino}>
          {destino.destination}
        </option>
      ))}
    </select>
  );
}

export default connect((state) => ({ choose: state.choose }))(Search);
