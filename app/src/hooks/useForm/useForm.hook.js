import { useState } from "react";

export function useForm(filme) {
  const [formInput, setFormInput] = useState(filme);

  const setData = ({ name, value }) => {
    setFormInput((oldData) => ({ ...oldData, [name]: value }));
  };

  return { formInput, setData };
}
