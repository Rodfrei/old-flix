import { createBrowserRouter } from "react-router-dom";
import { Catalogo, Detalhes } from "../ui/screens";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <Catalogo />,
  },
  {
    path: "/detalhes",
    element: <Detalhes />,
  },
]);
