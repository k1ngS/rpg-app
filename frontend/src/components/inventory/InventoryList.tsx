import { useEffect, useState } from "react";
import { getInventory, addItem, deleteItem } from "@/services/inventoryService";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Card, CardContent, CardTitle } from "@/components/ui/card";
import { toast } from "sonner";

export default function InventoryList({ characterId }: { characterId: number }) {
  const [items, setItems] = useState<any[]>([]);
  const [newItem, setNewItem] = useState("");

  const fetchInventory = () => {
    getInventory(characterId).then(r => setItems(r.data));
  };

  useEffect(() => {
    if (characterId) fetchInventory();
  }, [characterId]);

  const handleAdd = (e: React.FormEvent) => {
    e.preventDefault();
    if (!newItem.trim()) return;
    addItem(characterId, { name: newItem })
      .then(() => {
        toast.success("Item adicionado!");
        setNewItem("");
        fetchInventory();
      })
      .catch(() => toast.error("Erro ao adicionar!"));
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
        <Input
          placeholder="Novo item"
          value={newItem}
          onChange={e => setNewItem(e.target.value)}
        />
        <Button type="submit">Adicionar</Button>
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
