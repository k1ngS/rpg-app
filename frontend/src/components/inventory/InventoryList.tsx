import { useEffect, useState } from "react";
import { getInventory, addItem, deleteItem } from "@/services/inventoryService";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardTitle } from "@/components/ui/card";
import { toast } from "sonner";
import { Label } from "../ui/label";
import { Select, SelectContent, SelectGroup, SelectItem, SelectTrigger, SelectValue } from "../ui/select";
import { getAllItems } from "@/services/itemService";

export default function InventoryList({ characterId }: { characterId: number }) {
  const [items, setItems] = useState<any[]>([]);
  const [itemsOptions, setItemsOptions] = useState<{key: string; label: string}[]>([]);
  const [newItem, setNewItem] = useState("");
  const [loading, setLoading] = useState(false);


  const fetchInventory = () => {
    getInventory(characterId).then(r => setItems(r.data));
  };

  useEffect(() => {
    if (characterId) fetchInventory();
    getAllItems().then(res => setItemsOptions(res.data));
  }, [characterId]);

  const handleAdd = (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    if (!newItem.trim()) return;
    addItem(characterId, { name: newItem })
      .then(() => {
        toast.success("Item adicionado!");
        setNewItem("");
        fetchInventory();
      })
      .catch(() => toast.error("Erro ao adicionar!"))
      .finally(() => setLoading(false));
  };

  const handleDelete = (id: number) => {
    deleteItem(characterId, id)
      .then(() => {
        toast.success("Item removido!");
        fetchInventory();
      })
      .catch(() => toast.error("Erro ao remover!"));
  };

  return (
    <div>
      <h3 className="font-bold mb-2">Inventário</h3>
      <form className="flex gap-2 mb-4" onSubmit={handleAdd}>
        {itemsOptions.length === 0 && <div className="text-sm text-muted-foreground">Nenhum item disponível para adicionar.</div>}
        {itemsOptions.length > 0 && (
          <>
            <Label htmlFor="characterClass">Classe</Label>
            <Select name="characterClass" onValueChange={setNewItem} value={newItem} disabled={loading} required>
              <SelectTrigger className="w-[180px]">
                <SelectValue placeholder="Select an item" />
              </SelectTrigger>

            <SelectContent>
              <SelectGroup>
                {itemsOptions.map(opt => (
                  <SelectItem key={opt.key} value={opt.key}>{opt.label}</SelectItem>
                ))}
              </SelectGroup>
            </SelectContent>
          </Select>
          <Button type="submit">Adicionar</Button>
          </>
        )}
      </form>
      <div className="grid gap-2">
        {items.length === 0 && <div className="text-sm text-muted-foreground">Sem itens.</div>}
        {items.map(item => (
          <Card key={item.id}>
            <CardContent className="flex justify-between items-center">
              <CardTitle>{item.itemName} x{item.quantity} {item?.itemRarity ? `(${item.itemRarity})` : null}</CardTitle>
              <Button size="sm" variant="destructive" onClick={() => handleDelete(item.id)}>
                Remover
              </Button>
            </CardContent>
          </Card>
        ))}
      </div>
    </div>
  );
}
