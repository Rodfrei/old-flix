import { axiosInstance } from "../_base/axios-instance";
import { useState } from "react";

export function useAlugarFilme() {
  const [mensagemAlugar, setMensagemAlugar] = useState(null);
  async function alugarFilme(id, responsavel) {
    try {
      const { data } = await axiosInstance.put(`/filmes/${id}/alugar`, {
        responsavel,
      });
      setMensagemAlugar(
        `O filme ${data.titulo} foi alugado por ${data.responsavel}.`
      );
    } catch (error) {
      setMensagemAlugar(error.response.data.message);
    }
  }
  return { mensagemAlugar, alugarFilme };
}
