import api from "../api";

export async function getContatos() {
  return (await api.get("/contatos")).data;
}
export async function deleteContato(id) {
  await api.delete(`/contatos/${id}`);
}
export async function postContato(contato) {
  await api.post("/contatos", {
    email: contato.email,
    nome: contato.nome,
    assunto: contato.assunto,
    mensagem: contato.mensagem,
  });
}
