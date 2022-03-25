import api from "../api";

export async function getPromocoes() {
  return (await api.get("/Promocoes")).data;
}
export async function deletarPromocao(id) {
  await api.delete(`/Promocoes/${id}`);
}
export async function postPromocao(promo) {
  await api.post("/Promocoes", {

    precoPromo: promo.precoPromo,
    
    data: promo.data,
    destino: { idDestino: promo.destino.idDestino },
  });
}
