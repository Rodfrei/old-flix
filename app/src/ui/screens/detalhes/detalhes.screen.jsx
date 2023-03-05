import React from "react";
import "./detalhes.style.css";
import { useState, useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import {
  useDetalharFilme,
  useAlugarFilme,
  useDevolverFilme,
  useEditarFilme,
  useRemoverFilme,
} from "../../../api";
import { Loader, Cabecalho, InserirEditarFilme } from "../../components";
import lixeira from "../../../assets/img/excluir.svg";

export function Detalhes() {
  const location = useLocation();
  const navigate = useNavigate();
  const { filme, isLoading, mensagemErro, detalharFilme } = useDetalharFilme();
  const { mensagemAlugar, alugarFilme } = useAlugarFilme();
  const { mensagemDevolver, devolverFilme } = useDevolverFilme();
  const { mensagemEditar, editarFilme } = useEditarFilme();
  const { mensagemRemover, isRemovido, removerFilme } = useRemoverFilme();
  const [isEditandoFilme, setIsEditandoFilme] = useState(false);
  const [responsavel, setResponsavel] = useState(null);

  useEffect(() => {
    detalharFilme(location.state.filmeId);
  }, [mensagemAlugar, mensagemDevolver, mensagemEditar]);

  useEffect(() => {
    if (isRemovido) {
      navigate("/");
    }
  }, [isRemovido]);

  const dadosParaEditar = {
    id: filme?.id,
    titulo: filme?.titulo,
    descricao: filme?.descricao,
    categoria: filme?.categoria,
    url: filme?.url,
    ano: filme?.ano,
    duracao: filme?.duracao,
  };

  function handleResponsavel(event) {
    setResponsavel(event.target.value);
  }

  function handleAlugarFilme() {
    alugarFilme(filme.id, responsavel);
  }

  function handleDevolverFilme() {
    devolverFilme(filme.id);
  }

  function handleEditarFilme() {
    setIsEditandoFilme(true);
  }

  function handleRemoverFilme() {
    removerFilme(filme.id);
  }

  function handleVoltar() {
    navigate("/");
  }

  function renderDetalhesFilme() {
    if (isLoading) return <Loader />;
    if (mensagemErro) return <p>{mensagemErro}</p>;
    return (
      <>
        <div className="detalhes-container-img">
          <img className="filme-img" src={filme.url} alt={filme.titulo} />
          <div className="locacao-container">
            {filme.disponivel ? (
              <div className="alugar-container">
                <button
                  onClick={handleAlugarFilme}
                  className="botao botao-positivo font"
                >
                  Alugar
                </button>
                <label className="input-responcavel-container">
                  <input
                    className="font detalhes-texto detalhes-texto-input-resposavel"
                    required
                    placeholder="Responsavel ..."
                    type="text"
                    onChange={handleResponsavel}
                  />
                </label>
              </div>
            ) : (
              <button
                onClick={handleDevolverFilme}
                className="botao botao-negativo font"
              >
                Devolver
              </button>
            )}
          </div>
        </div>
        <div className="detalhes-container-informacoes font">
          <h2 className="detalhes-informacoes-titulo">{filme.titulo}</h2>
          <p className="detalhes-texto">Categoria: {filme.categoria}</p>
          <p className="detalhes-texto">Ano: {filme.ano}</p>
          <p className="detalhes-texto">Duração: {filme.duracao}min</p>
          <p className="detalhes-texto">Descrição: {filme.descricao}</p>
          {!filme.disponivel && (
            <>
              <p className="detalhes-aluguel-titulo">DADOS DO ALUGUEL</p>
              <p className="detalhes-texto">Responsavel: {filme.responsavel}</p>
              <p className="detalhes-texto">Situação: {filme.situacao}</p>
              <p className="detalhes-texto">
                Data retirada: {filme.dataRetirada}
              </p>
              <p className="detalhes-texto">
                Data entrega: {filme.dataEntrega}
              </p>
            </>
          )}
        </div>
      </>
    );
  }

  return (
    <>
      <Cabecalho />
      <div className="gerenciar-filme-detalhes">
        <button onClick={handleVoltar} className="botao-gerenciar font">
          Voltar
        </button>
        <button onClick={handleEditarFilme} className="botao-gerenciar font">
          Editar Filme
        </button>
        <button onClick={handleRemoverFilme} className="botao-excluir">
          <img className="image-excluir" src={lixeira} alt="excluir" />
        </button>
      </div>
      {isEditandoFilme ? (
        <InserirEditarFilme
          incluirOuEditarFilme={editarFilme}
          setIsIncluindoOuEditandoFilme={setIsEditandoFilme}
          filme={dadosParaEditar}
        />
      ) : (
        <div className="detalhes-container">{renderDetalhesFilme()}</div>
      )}
    </>
  );
}
