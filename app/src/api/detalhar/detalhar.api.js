import { axiosInstance } from "../_base/axios-instance";
import { useState } from "react";

export function useDetalharFilme() {
  const [filme, setFilme] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [mensagemErro, setMensagemErro] = useState(null);

  async function detalharFilme(id) {
    try {
      setIsLoading(true);
      const response = await axiosInstance.get(`/filmes/${id}`);
      setFilme(response.data);
      setMensagemErro(null);
    } catch (error) {
      setMensagemErro(error.response.data.message);
    } finally {
      setIsLoading(false);
    }
  }

  return { filme, isLoading, mensagemErro, detalharFilme };
}
