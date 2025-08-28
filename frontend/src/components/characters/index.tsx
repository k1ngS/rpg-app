import React, { useState } from 'react';
import CharacterList from './CharacterList';
import CharacterForm from './CharacterForm';

const CharactersPage: React.FC = () => {
  const [refresh, setRefresh] = useState(false);

  const triggerRefresh = () => setRefresh(r => !r);

  return (
    <div className="max-w-xl mx-auto mt-8">
      <h1 className="text-2xl font-bold mb-6">Gerenciador de Personagens</h1>
      <CharacterForm onCreated={triggerRefresh} />
      {/* Force re-montagem da CharacterList ao criar um personagem */}
      <CharacterList key={refresh ? 'a' : 'b'} />
    </div>
  );
};

export default CharactersPage;
