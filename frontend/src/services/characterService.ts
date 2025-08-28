import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/characters';

export const getAllCharacters = () => axios.get(BASE_URL);

export const createCharacter = (data: any) => axios.post(BASE_URL, data);

export const updateCharacter = (id: number, data: any) => axios.put(`${BASE_URL}/${id}`, data);

export const deleteCharacter = (id: number) => axios.delete(`${BASE_URL}/${id}`);