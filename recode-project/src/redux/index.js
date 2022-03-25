import { createStore } from "redux";

const initialState = {
  choose: "Promoções",
};
function destino(state = initialState, action) {
  if (action.type === "PUT") {
    return { ...state, choose: action.choose};
  } else if (action.type === "RESET") {
    return { ...state, choose: action.choose };
  }
  return state;
}
const store = createStore(destino);
export default store;
