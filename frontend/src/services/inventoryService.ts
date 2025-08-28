import axios from "axios";
const BASE_URL = "http://localhost:8080/api/characters";

export const getInventory = (characterId: number) => axios.get(`${BASE_URL}/${characterId}/inventory`);
export const addItem = (characterId: number, data: any) => axios.post(`${BASE_URL}/${characterId}/inventory`, data);
export const updateItem = (characterId: number, itemId: number, data: any) =>
  axios.put(`${BASE_URL}/${characterId}/inventory/${itemId}`, data);
export const deleteItem = (characterId: number, itemId: number) =>
  axios.delete(`${BASE_URL}/${characterId}/inventory/${itemId}`);
