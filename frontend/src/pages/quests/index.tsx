import { useEffect, useState } from 'react'

type Quest = { id:number; title:string; description?:string; status:string; createdAt:string };

const Quests = () => {
  const [quests, setQuests] = useState<Quest[]>([]);
  const [title, setTitle] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/quests")
      .then(r => r.json())
      .then(p => setQuests(p.content ?? []));
  }, []);

  const handleCreate = async () => {
    await fetch("http://localhost:8080/api/quests", {
      method: "POST",
      headers: { "Content-Type":"application/json" },
      body: JSON.stringify({ title })
    });
    const r = await fetch("http://localhost:8080/api/quests");
    const p = await r.json();
    setQuests(p.content ?? []);
    setTitle("");
  };

  return (
    <>
      <h1 className="text-6xl">Quests</h1>
      <ul>{quests.map(q => <li key={q.id}>{q.title} — {q.status}</li>)}</ul>
      <div className="flex gap-4">
        <input className="bg-gray-800 border border-gray-700 rounded p-2" value={title} onChange={e=>setTitle(e.target.value)} placeholder="Título" />
        <button className="w-20 bg-blue-600 hover:bg-blue-700 rounded p-2" onClick={handleCreate}>Criar</button>
      </div>
    </>
  )
}

export default Quests