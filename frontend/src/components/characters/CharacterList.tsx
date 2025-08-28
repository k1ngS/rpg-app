import { Card, CardContent, CardTitle } from "@/components/ui/card";
import { useEffect, useState } from "react";
import { getAllCharacters} from "@/services/characterService";
import { useNavigate } from "react-router";

export default function CharacterList() {
  const [characters, setCharacters] = useState<any[]>([]);
  const navigate = useNavigate();

  function fetchCharacters() {
    getAllCharacters().then(r => setCharacters(r.data));
  }

  useEffect(() => {
    fetchCharacters();
  }, []);

  return (
    <div className="grid gap-4 grid-cols-1 md:grid-cols-2">
      {characters.map(c => (
        <Card
          key={c.id}
          onClick={() => navigate(`/characters/${c.id}`)}
          className="cursor-pointer hover:shadow-lg"
        >
          <CardContent>
            <CardTitle>{c.name}</CardTitle>
            <div>Nível: {c.level ?? "-"}</div>
            <div>Classe: {c.characterClass ?? "-"}</div>
          </CardContent>
        </Card>
      ))}
    </div>
  );
}
