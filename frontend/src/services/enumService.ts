import axios from "axios";

const BASE_URL = "http://localhost:8080/api/enums";

export const getClasses = () => axios.get(BASE_URL + "/classes");
export const getAncestries = () => axios.get(BASE_URL + "/ancestries");
export const getRarities = () => axios.get(BASE_URL + "/rarities");