import { axiosInstance } from "../_base/axios-instance";
import { useState } from "react";
export function useDevolverFilme() {
  const [mensagemDevolver, setMensagemDevolver] = useState(null);
  async function devolverFilme(id) {
    try {
      await axiosInstance.put(`/filmes/${id}/devolver`);
      setMensagemDevolver(`O filme foi devolvido com sucesso.`);
    } catch (error) {
      setMensagemDevolver(error.response.data.message);
    }
  }

  return { mensagemDevolver, devolverFilme };
}
