import { axiosInstance } from "../_base/axios-instance";
import { useState } from "react";
export function useRemoverFilme() {
  const [mensagemRemover, setMensagemRemover] = useState(null);
  const [isRemovido, setIsRemovido] = useState(false);
  async function removerFilme(id) {
    try {
      await axiosInstance.delete(`/filmes/${id}`);
      setMensagemRemover(`O filme foi removido com sucesso.`);
      setIsRemovido(true);
    } catch (error) {
      setMensagemRemover(error.response.data.message);
      setIsRemovido(false);
    }
  }

  return { mensagemRemover, isRemovido, removerFilme };
}
