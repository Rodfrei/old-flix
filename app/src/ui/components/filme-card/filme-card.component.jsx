import React from "react";
import "./filme-card.style.css";
import disponivel from "../../../assets/img/disponivel.png";
import indisponivel from "../../../assets/img/indisponivel.png";
import lixeira from "../../../assets/img/excluir.svg";
export function FilmeCard({ filme, remover }) {
  function verificaDisponibilidade() {
    if (filme.disponivel) {
      return disponivel;
    }
    return indisponivel;
  }

  return (
    <div className={`card-container card-color-${filme.categoria}`}>
      <div className="img-card-container">
        <div className="descricao-titulo-filme-card">
          <p className="titulo-filme-card font">{filme.titulo}</p>
          <p className="descricao-filme-card font">{filme.descricao}</p>
        </div>
        <img className="img-card" src={filme.url} alt={filme.titulo} />
      </div>

      <div className={`card-footer font`}>
        <span>{filme.duracao}min</span>
        <img
          className="disponibilidado-filme-card"
          src={verificaDisponibilidade()}
          alt="Disponibilidade do filme"
        />
        <span>{filme.ano}</span>
      </div>
    </div>
  );
}
