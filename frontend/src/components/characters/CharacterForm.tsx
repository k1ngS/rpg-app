import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useEffect, useState } from "react";
import { toast } from "sonner";
import { getClasses, getAncestries } from "@/services/enumService";
import { Select, SelectContent, SelectGroup, SelectItem, SelectLabel, SelectTrigger, SelectValue } from "../ui/select";

interface Props {
  initial?: any;
  onSubmit: () => void;
  isEdit?: boolean;
  saveCharacter: (data: any) => Promise<any>;
}

export default function CharacterForm({ initial, onSubmit, isEdit, saveCharacter }: Props) {
  const [name, setName] = useState(initial?.name ?? "");
  const [level, setLevel] = useState(initial?.level ?? 1);
  const [characterClass, setCharacterClass] = useState(initial?.characterClass ?? "");
  const [characterAncestry, setCharacterAncestry] = useState(initial?.characterAncestry ?? "Humano");
  const [classOptions, setClassOptions] = useState<{key: string; label: string}[]>([]);
  const [ancestryOptions, setAncestryOptions] = useState<{key: string; label: string}[]>([]);
  const [attributes, setAttributes] = useState(initial?.attributes ?? {
    strengh: 10,
    agility: 10,
    intelligence: 10,
    will: 10
  });
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setName(initial?.name ?? "");
    setLevel(initial?.level ?? 1);
    setCharacterClass(initial?.characterClass ?? "");
    setCharacterAncestry(initial?.characterAncestry ?? "");

    getClasses().then(res => setClassOptions(res.data));
    getAncestries().then(res => setAncestryOptions(res.data));
  }, [initial]);


  function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setLoading(true);
    saveCharacter({ name, level, characterClass, characterAncestry, attributes })
      .then(() => {
        toast.success(isEdit ? "Personagem atualizado!" : "Personagem criado!");
        onSubmit();
      })
      .catch(() => toast.error("Erro ao salvar personagem"))
      .finally(() => setLoading(false));
  }

  return (
    <form onSubmit={handleSubmit} className="flex flex-col gap-2 min-w-[250px]">
      <Label htmlFor="name">Nome</Label>
      <Input id="name" value={name} onChange={e => setName(e.target.value)} required disabled={loading} />

      <Label htmlFor="level">Nível</Label>
      <Input id="level" type="number" min={1} value={level} onChange={e => setLevel(Number(e.target.value))} required disabled={loading} />

      <div className="flex gap-4">
        <div className="space-y-4">
          <Label htmlFor="characterClass">Classe</Label>
          <Select name="characterClass" onValueChange={setCharacterClass} value={characterClass} disabled={loading} required>
            <SelectTrigger className="w-[180px]">
              <SelectValue placeholder="Select a class" />
            </SelectTrigger>
            <SelectContent>
              <SelectGroup>
                {classOptions.map(opt => (
                  <SelectItem key={opt.key} value={opt.key}>{opt.label}</SelectItem>
                ))}
              </SelectGroup>
            </SelectContent>
          </Select>
        </div>

        <div className="space-y-4">
          <Label htmlFor="characterAncestry">Ascendência</Label>
          <Select name="characterAncestry" onValueChange={setCharacterAncestry} value={characterAncestry} disabled={loading} required>
            <SelectTrigger className="w-[180px]">
              <SelectValue placeholder="Select a ancestry" />
            </SelectTrigger>
            <SelectContent>
              <SelectGroup>
                {ancestryOptions.map(opt => (
                  <SelectItem key={opt.key} value={opt.key}>{opt.label}</SelectItem>
                ))}
              </SelectGroup>
            </SelectContent>
          </Select>
        </div>
      </div>

      <Button type="submit" disabled={loading}>
        {isEdit ? "Salvar alterações" : "Criar personagem"}
      </Button>
      <Button type="button" variant="secondary" onClick={() => isEdit && onSubmit()} disabled={loading}>
        Cancelar
      </Button>
    </form>
  );
}
