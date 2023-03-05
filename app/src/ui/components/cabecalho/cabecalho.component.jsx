import React from "react";
import "./cabecalho.style.css";
import pipoca from "../../../assets/img/pipoca.svg";

export function Cabecalho() {
  return (
    <header className="cabecalho">
      <img className="pipoca-icon" src={pipoca} alt="pipoca" />
      <h1 className="cabecalho-titulo font">OldFlix</h1>
      <img className="pipoca-icon" src={pipoca} alt="pipoca" />
    </header>
  );
}
