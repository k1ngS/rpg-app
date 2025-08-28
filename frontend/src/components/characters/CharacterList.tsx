import React, { useEffect, useState } from 'react';
import { getAllCharacters, deleteCharacter } from '../../services/characterService';

interface Character {
  id: number;
  name: string;
  level?: number;
  // Adicione outros campos que existirem no seu backend
}

const CharacterList: React.FC = () => {
  const [characters, setCharacters] = useState<Character[]>([]);
  const [loading, setLoading] = useState(true);

  const fetchCharacters = () => {
    setLoading(true);
    getAllCharacters()
      .then(response => setCharacters(response.data))
      .finally(() => setLoading(false));
  };

  useEffect(() => {
    fetchCharacters();
  }, []);

  const handleDelete = (id: number) => {
    if (window.confirm('Tem certeza que deseja deletar este personagem?')) {
      deleteCharacter(id)
        .then(fetchCharacters)
        .catch(e => alert('Erro ao deletar personagem'));
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-lg font-bold mb-4">Seus Personagens</h2>
      {loading && <div>Carregando...</div>}
      {!loading && (
        <ul className="space-y-2">
          {characters.map(c => (
            <li key={c.id} className="flex items-center justify-between bg-gray-800 p-2 rounded">
              <span>
                {c.name} {c.level && <small>(Nv. {c.level})</small>}
              </span>
              <button
                className="bg-red-500 text-white px-2 py-1 rounded"
                onClick={() => handleDelete(c.id)}
              >
                Remover
              </button>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default CharacterList;
