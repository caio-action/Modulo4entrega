/* eslint-disable jsx-a11y/img-redundant-alt */
/* eslint-disable import/no-anonymous-default-export */
import React from "react";
import "./Card.css";

export default (props) => {
  return (
    <section className="aqui">
      <>
        <div
          id="carouselExampleControls"
          className="carousel slide mb-3"
          data-ride="carousel"
        >
          <div className="carousel-inner">
            <div className="carousel-item active">
              <div className="card carousel-caption ">
                <p>
                  Vai dizer que nunca teve esse sonho ? Amsterdã , friozinho,
                  paisagem linda e fumaça subindo ... Vêm que a gente te dá
                  carona no arco-iris e no final tem duende esperando com "POT"
                  rs.
                </p>
                <img
                  className="d-block w-100"
                  src={props.imga}
                  alt="Card image cap"
                />
              </div>
            </div>
            <div className="carousel-item">
              <div className="card carousel-caption ">
                <p>
                  Vai dizer que nunca teve esse sonho ? Amsterdã , friozinho,
                  paisagem linda e fumaça subindo ... Vêm que a gente te dá
                  carona no arco-iris e no final tem duende esperando com "POT"
                  rs.
                </p>
                <img
                  className="d-block w-100"
                  src={props.imgp}
                  alt="Foto de apresentação"
                />
              </div>
            </div>
            <div className="carousel-item">
              <div className="card carousel-caption  ">
                <p>
                  Vai dizer que nunca teve esse sonho ? Amsterdã , friozinho,
                  paisagem linda e fumaça subindo ... Vêm que a gente te dá
                  carona no arco-iris e no final tem duende esperando com "POT"
                  rs.
                </p>
                <img
                  className="d-block w-100"
                  src={props.imgu}
                  alt="Foto de apresentação"
                />
              </div>
            </div>
            <a
              className="carousel-control-prev"
              href="#carouselExampleControls"
              role="button"
              data-slide="prev"
            >
              <span
                className="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span className="sr-only">Anterior</span>
            </a>
            <a
              className="carousel-control-next"
              href="#carouselExampleControls"
              role="button"
              data-slide="next"
            >
              <span
                className="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span className="sr-only">Próximo</span>
            </a>
          </div>
        </div>
      </>
    </section>
  );
};
