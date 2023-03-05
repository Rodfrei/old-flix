import React from "react";
import "./catalogo.style.css";
import { useFilmes, useRemoverFilme, useIncluirFilme } from "../../../api";
import { useEffect, useState } from "react";
import {
  FilmeCard,
  Loader,
  Cabecalho,
  InserirEditarFilme,
} from "../../components";
import { Link } from "react-router-dom";
export function Catalogo() {
  const { filmes, isLoading, mensagemErro, buscarFilmes } = useFilmes();
  const { mensagemRemover, removerFilme } = useRemoverFilme();
  const { mensagemIncluir, incluirFilme } = useIncluirFilme();
  const [isIncluindoFilme, setIsIncluindoFilme] = useState(false);

  const novoFilme = {
    titulo: "",
    descricao: "",
    categoria: "",
    url: "",
    ano: "",
    duracao: "",
  };

  function handleInserirFilme() {
    setIsIncluindoFilme(true);
  }

  useEffect(() => {
    buscarFilmes();
  }, [mensagemRemover, mensagemIncluir]);

  function renderCatalogo() {
    if (isLoading) return <Loader />;
    if (mensagemErro) return <p>{mensagemErro}</p>;
    return filmes.map((filme) => (
      <Link
        key={filme.id}
        to="/detalhes"
        state={{ filmeId: filme.id }}
        style={{ textDecoration: "none" }}
      >
        <FilmeCard key={filme.id} filme={filme} remover={removerFilme} />
      </Link>
    ));
  }
  return (
    <>
      <Cabecalho />
      <div className="gerenciar-filme">
        <button className="botao-gerenciar font" onClick={handleInserirFilme}>
          Inserir Filme
        </button>
      </div>
      {isIncluindoFilme ? (
        <InserirEditarFilme
          filme={novoFilme}
          incluirOuEditarFilme={incluirFilme}
          setIsIncluindoOuEditandoFilme={setIsIncluindoFilme}
        />
      ) : (
        <div className="catalogo-container">{renderCatalogo()}</div>
      )}
    </>
  );
}
