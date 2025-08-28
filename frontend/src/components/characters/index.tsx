import CharacterList from "@/components/characters/CharacterList";
import CharacterForm from "@/components/characters/CharacterForm";
import { createCharacter } from "@/services/characterService";
import { useState } from "react";

export default function CharactersPage() {
  const [refresh, setRefresh] = useState(false);

  const triggerRefresh = () => setRefresh(r => !r);

  return (
    <div className="max-w-2xl mx-auto mt-10 space-y-6">
      <h1 className="text-2xl font-bold">Meus Personagens</h1>
      <CharacterForm initial={null} onSubmit={triggerRefresh} saveCharacter={createCharacter} />
      <CharacterList key={refresh.toString()} />
    </div>
  );
}
