import { Dialog, DialogContent, DialogHeader, DialogTitle, DialogDescription, DialogClose } from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import CharacterForm from "./CharacterForm";
import { useState } from "react";
import InventoryList from "../inventory/InventoryList";

interface Props {
  character: any;
  open: boolean;
  onClose: () => void;
  onUpdate: (updated: any) => void;
  onDelete: (id: number) => void;
  saveCharacter: (data: any) => Promise<any>;
}

export default function CharacterDetailsModal({ character, open, onClose, onUpdate, onDelete, saveCharacter }: Props) {
  const [edit, setEdit] = useState(false);

  if (!character) return null;

  return (
    <Dialog open={open} onOpenChange={onClose}>
      <DialogContent>
        <DialogHeader>
          <DialogTitle>{edit ? "Editar personagem" : character.name}</DialogTitle>
          <DialogDescription>
            {edit ? "Edite os dados e salve" : "Detalhes do personagem"}
          </DialogDescription>
        </DialogHeader>
        {edit ? (
          <CharacterForm
            initial={character}
            onSubmit={() => {
              setEdit(false);
              onUpdate(character);
            }}
            isEdit
            saveCharacter={(data) => saveCharacter({ ...character, ...data })}
          />
        ) : (
          <>
            <div className="mb-2">Nível: {character.level}</div>
            <div className="mb-2">Classe: {character.classe || "—"}</div>
            <InventoryList characterId={character.id} />
            {/* Adicione outros atributos */}
            <div className="flex gap-2 mt-4">
              <Button variant="default" onClick={() => setEdit(true)}>Editar</Button>
              <Button variant="destructive" onClick={() => { onDelete(character.id); onClose(); }}>Remover</Button>
              <DialogClose asChild>
                <Button variant="secondary">Fechar</Button>
              </DialogClose>
            </div>
          </>
        )}
      </DialogContent>
    </Dialog>
  );
}
