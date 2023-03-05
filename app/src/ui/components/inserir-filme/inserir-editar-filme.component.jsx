import React from "react";
import "./inserir-filme.style.css";
import { useForm } from "../../../hooks/useForm/useForm.hook";
import { useEffect } from "react";
export function InserirEditarFilme({
  incluirOuEditarFilme,
  setIsIncluindoOuEditandoFilme,
  filme,
}) {
  const { formInput, setData } = useForm(filme);

  function handleChange(event) {
    setData(event.target);
  }

  function handleSubmit(event) {
    event.preventDefault();
    if (filme) {
      incluirOuEditarFilme(filme.id, formInput);
    }

    setIsIncluindoOuEditandoFilme(false);
  }

  return (
    <div className="formulario-inserir-filme-container">
      <form className="formulario-inserir-filme font" onSubmit={handleSubmit}>
        <div className="input-dois-dados">
          <label className="caixa-do-dado caixa-do-dado-menor">
            <span>Titulo</span>
            <input
              className="input-dado"
              required
              onChange={handleChange}
              type="text"
              name="titulo"
              defaultValue={filme?.titulo}
            />
          </label>
          <label className="caixa-do-dado caixa-do-dado-menor">
            <span>Categoria</span>
            <select
              className="input-dado"
              required
              onChange={handleChange}
              name="categoria"
              defaultValue={filme?.categoria}
            >
              <option disabled value="">
                Selecione ...
              </option>
              <option value="OURO">OURO</option>
              <option value="PRATA">PRATA</option>
              <option value="BRONZE">BRONZE</option>
            </select>
          </label>
        </div>
        <div className="input-dois-dados">
          <label className="caixa-do-dado caixa-do-dado-menor">
            <span>Ano</span>
            <input
              className="input-dado"
              required
              onChange={handleChange}
              type="number"
              name="ano"
              defaultValue={filme?.ano}
            />
          </label>
          <label className="caixa-do-dado caixa-do-dado-menor">
            <span>Duração</span>
            <input
              className="input-dado"
              required
              onChange={handleChange}
              type="number"
              name="duracao"
              defaultValue={filme?.duracao}
            />
          </label>
        </div>
        <label className="caixa-do-dado caixa-do-dado-maior">
          <span>URL da imagem</span>
          <input
            className="input-dado"
            required
            onChange={handleChange}
            type="text"
            name="url"
            defaultValue={filme?.url}
          />
        </label>
        <label className="caixa-do-dado caixa-do-dado-maior">
          <span>Descrição</span>
          <textarea
            rows="5"
            className="input-dado"
            required
            onChange={handleChange}
            name="descricao"
            defaultValue={filme?.descricao}
          ></textarea>
        </label>
        <div className="contsiner-botoes-formulario-inserir-filme">
          <button className="botao botao-positivo font">Salvar</button>
          <button
            className="botao botao-negativo font"
            onClick={() => setIsIncluindoOuEditandoFilme(false)}
          >
            Cancelar
          </button>
        </div>
      </form>
    </div>
  );
}
