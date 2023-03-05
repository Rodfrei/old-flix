import { axiosInstance } from "../_base/axios-instance";
import { useState } from "react";

export function useFilmes() {
  const [filmes, setFilmes] = useState(null);
  const [isLoading, setIsLoading] = useState(true);
  const [mensagemErro, setMensagemErro] = useState(null);

  async function buscarFilmes() {
    try {
      setIsLoading(true);
      const response = await axiosInstance.get("/filmes");
      setFilmes(response.data);
      setMensagemErro(null);
    } catch (error) {
      setMensagemErro("Não foi possivel acessar o catalogo.");
    } finally {
      setIsLoading(false);
    }
  }

  return { filmes, isLoading, mensagemErro, buscarFilmes };
}
