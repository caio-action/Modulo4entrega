/* eslint-disable import/no-anonymous-default-export */
import CardPromo from "./CardPromo/CardPromo";
import bob from "../../Assets/img/bobviagem.png";
import  React,{ useState, useEffect } from "react";
import Search from "../Promo/Search";
import { getPromocoes } from "../../service/PromocaoService";
import { connect } from "react-redux";
import FormCadastroPromocao from "../../Components/FormCadastroPromocao/FormCadastroPromocao"

function Promo({ destination }) {
  const [promo, setPromocao] = useState([]);

  useEffect(() => {
    getPromocoes()
      .then((res) => setPromocao(res))
      .catch((erro) => console.log(erro));
  }, []);

  return (
    <main>
      <section className="container-fluid mb-2 text-center">
        <h1 className="font-config pt-3">Promoções</h1>
        <Search />
      </section>

      <div className="promo-view">
        {promo.map((promo) => {
          if (
            destination === promo.destino.destination ||
            destination === "Promoções"
          ) {
            return (
              <CardPromo
                destino={promo.destino.destination}
                fotoPromo={
                  promo.destino.foto === ""
                    ? bob: promo.destino.foto
                }
                dataVoo={promo.data}
                localEmbarque={promo.localPartida}
                preco={promo.precoPromo}
                key={promo.idPromo}
              />
              );
            }
          })}
          </div>

      {/* <main>
      <section className="container-fluid mb-2 text-center">
        <h1 className="title-container">Promoções</h1>
        <Search/>
      </section>
      
      <div className="promo-view">
          {promo.map((_Promocao) => (
            <CardPromo 
            destino = {promo.destino.nomeDestino} 
            dataVoo={promo.data} 
            localEmbarque={promo.localPartida} 
            preco={promo.precoPromo}  
            key= {promo.idPromo}
            imgPromo={(promo.destino.foto === ""? bob:promo.destino.foto)}/>
          ))}
          </div>
      
      
      <div className="promo-view">
        <CardPromo destino={"Montevidéo"} imgPromo={bob} />
        <CardPromo destino={"Amsterdã"} imgPromo={bob} />
        <CardPromo destino={"Los Angeles"} imgPromo={bob} />
        <CardPromo destino={"Santiago"} imgPromo={bob} />
        <CardPromo destino={"Lisboa"} imgPromo={bob} />
        <CardPromo destino={"Jamaica"} imgPromo={bob} />
      </div> */}
    </main>
  );
}
export default connect((state) => ({
  choose: state.choose,
}))(Promo);
