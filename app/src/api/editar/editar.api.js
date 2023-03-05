import { axiosInstance } from "../_base/axios-instance";
import { useState } from "react";

export function useEditarFilme() {
  const [mensagemEditar, setMensagemEditar] = useState(null);
  async function editarFilme(
    id,
    { titulo, descricao, categoria, url, ano, duracao }
  ) {
    try {
      const { data } = await axiosInstance.put(`/filmes/${id}`, {
        titulo,
        descricao,
        categoria,
        url,
        ano,
        duracao,
      });
      setMensagemEditar(`O filme ${data.titulo} foi editado.`);
    } catch (error) {
      setMensagemEditar(error.response.data.message);
    }
  }
  return { mensagemEditar, editarFilme };
}
