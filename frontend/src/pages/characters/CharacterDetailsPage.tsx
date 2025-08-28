import { useEffect, useState } from "react";
import { getAllCharacters, updateCharacter, deleteCharacter } from "@/services/characterService";
import CharacterForm from "@/components/characters/CharacterForm";
import { Button } from "@/components/ui/button";
import InventoryList from "@/components/inventory/InventoryList";
import { useNavigate, useParams } from "react-router";
import { toast } from "sonner";

export default function CharacterDetailsPage() {
  const { id } = useParams();
  const charId = Number(id);
  const [character, setCharacter] = useState<any>(null);
  const [edit, setEdit] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    getAllCharacters().then(r => {
      setCharacter(r.data.find((x: any) => x.id === charId));
    });
  }, [charId]);

  function handleSave(data: any) {
    updateCharacter(charId, data)
      .then(() => {
        toast.success("Personagem atualizado!");
        setCharacter({ ...character, ...data });
        setEdit(false);
      })
      .catch(() => toast.error("Erro ao salvar personagem"));
  }

  function handleDelete() {
    deleteCharacter(charId)
      .then(() => {
        toast.error("Personagem excluído");
        navigate("/characters");
      })
      .catch(() => toast.error("Erro ao excluir personagem"));
  }

  if (!character) return <div className="p-10">Carregando...</div>;

  return (
    <div className="max-w-2xl mx-auto py-8 space-y-6">
      <div className="flex items-center justify-between">
        <h1 className="text-2xl font-bold">
          {edit ? "Editar personagem" : `Detalhes: ${character.name}`}
        </h1>
        {!edit && (
          <Button onClick={() => setEdit(true)} className="ml-4">
            Editar
          </Button>
        )}
      </div>
      {edit ? (
        <CharacterForm
          initial={character}
          isEdit
          onSubmit={() => setEdit(false)}
          saveCharacter={(data) => {
            handleSave(data);
            return Promise.resolve();
          }}
        />
      ) : (
        <div className="space-y-3">
          <div><strong>Nível:</strong> {character.level}</div>
          <div><strong>Classe:</strong> {character.characterClass}</div>
        </div>
      )}

      <InventoryList characterId={charId} />

      <div className="flex justify-between mt-6">
        <Button variant="secondary" onClick={() => navigate("/characters")}>Voltar</Button>
        <Button variant="destructive" onClick={handleDelete}>Excluir personagem</Button>
      </div>
    </div>
  );
}
