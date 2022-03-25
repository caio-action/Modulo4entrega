import api from "../api";

export async function getDestinos() {
  return (await api.get("/destinos")).data;
}
export async function deletarDestino(id) {
  await api.delete(`/destinos/${id}`);
}
export async function postDestino(destino) {
  await api.post("/destinos", {
    nomeDestino: destino.nomeDestino,
    txt: destino.txt,
    foto: destino.foto,
  });
}
