import { Link, Outlet } from "react-router"

const Layout = () => {
  return (
    <main className="h-screen overflow-hidden mx-auto bg-gray-900 text-gray-200">
      <header className="flex items-center justify-between gap-4 p-4">
        <h1 className="text-4xl">My App</h1>
        <nav className="flex gap-4">
          <Link to="/characters">Characters</Link>
          <Link to="/quests">Quests</Link>
          <Link to="/items">Items</Link>
        </nav>
        <div className="flex gap-4">
          <button className="bg-blue-600 hover:bg-blue-700 rounded p-2">Login</button>
          <button className="bg-red-600 hover:bg-red-700 rounded p-2">Logout</button>
        </div>
      </header>
      <div className="flex flex-col gap-8 items-center h-full justify-center">
        <Outlet />
      </div>
    </main>
  )
}

export default Layout