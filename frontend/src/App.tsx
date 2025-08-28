import { Route, Routes } from "react-router";
import Layout from "./Layout";
import Characters from "./pages/characters";
import Quests from "./pages/quests";
import CharacterDetailsPage from "./pages/characters/CharacterDetailsPage";

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route path="/characters" element={<Characters />} />
        <Route path="/characters/:id" element={<CharacterDetailsPage />} />
        <Route path="/quests" element={<Quests />} />
        <Route path="/items" element={<div>Item List Component Here</div>} />
      </Route>
    </Routes>
  );
}
