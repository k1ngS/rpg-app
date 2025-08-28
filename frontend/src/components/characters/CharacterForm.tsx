import React, { useState } from 'react';
import { createCharacter } from '../../services/characterService';

interface Props {
  onCreated: () => void;
}

const CharacterForm: React.FC<Props> = ({ onCreated }) => {
  const [name, setName] = useState('');
  // Adicione outros campos conforme sua modelagem (level, classe, etc.)

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    createCharacter({
      name,
      level: 0,
      attributes: {
        strength: 0,
        agility: 0,
        intelligence: 0,
        will: 0
      },
      defense: 0,
      health: 0,
      corruption: 0,
      insanity: 0,
      fortune: 0,
      characterClass: "Guerreiro",
      characterAncestry: "Humano"
    })
      .then(() => {
        setName('');
        onCreated();
      })
      .catch(e => alert('Erro ao criar personagem'));
  };

  return (
    <form onSubmit={handleSubmit} className="mb-4 flex gap-2 items-end">
      <div>
        <label htmlFor="name" className="block text-sm font-medium">Nome</label>
        <input
          id="name"
          required
          value={name}
          onChange={e => setName(e.target.value)}
          className="border p-1 rounded"
        />
      </div>
      <button type="submit" className="bg-blue-600 text-white px-3 py-1 rounded">Adicionar</button>
    </form>
  );
};

export default CharacterForm;
