import { axiosInstance } from "../_base/axios-instance";
import { useState } from "react";

export function useIncluirFilme() {
  const [mensagemIncluir, setMensagemIncluir] = useState(null);
  async function incluirFilme(
    id,
    { titulo, descricao, categoria, url, ano, duracao }
  ) {
    try {
      const { data } = await axiosInstance.post("/filmes", {
        titulo,
        descricao,
        categoria,
        url,
        ano,
        duracao,
      });
      setMensagemIncluir(`O filme ${data.titulo} foi inserido.`);
    } catch (error) {
      setMensagemIncluir(error.response.data.message);
    }
  }
  return { mensagemIncluir, incluirFilme };
}
