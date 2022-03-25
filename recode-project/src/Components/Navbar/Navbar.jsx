/* eslint-disable import/no-anonymous-default-export */
/* eslint-disable jsx-a11y/anchor-is-valid */
/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable react/jsx-no-duplicate-props */

import './Navbar.css';
import { Link } from "react-router-dom";
function Navbar(props){
    
        return(
           
           <nav className="navbar navbar-expand-lg navbar-light bg-light ">
          <a className="navbar-brand" >
            <div className="ico">
              <p className="text"> <img src={props.img} className="icon"></img> QueerTrip</p>
            </div>
          </a>
          <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" 
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Alterna navegação">
            <span className="navbar-toggler-icon"></span>
          </button>
          <div className="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
            <div className="navbar-nav">
               
                 <p className="linke">
                   <Link to={"/"}>
                   <a className="nav-item nav-link active" >Home <span className="sr-only"></span></a> 
                   </Link></p> 
              
              <p className="linke">
              <Link to={"/Promocoes"}>
                <a className="nav-item nav-link" >Promoções</a>
                </Link>
                </p>
                
              <p className="linke">
              <Link to={"/Destinos"}><a className="nav-item nav-link " >Destinos</a>
              </Link></p>
              
              <p className="linke">
              <Link to={"/Contatos"}>
                <a className="nav-item nav-link" >Contato</a>
               </Link>
                </p>
                <p className="linke">
              <Link to={"/Cadastro"}>
                <a className="nav-item nav-link" >Cadastro</a>
               </Link>
                </p>
            </div>
          </div>
          
          
        </nav>
        )
}
export default Navbar;

