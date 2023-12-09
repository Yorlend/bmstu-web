import { Homepage } from "@/routes/home"
import Postpage from "@/routes/post"
import { Metadata } from "next"
import { Inter } from "next/font/google"
import { BrowserRouter, HashRouter, Link, Route, Routes } from "react-router-dom"
import { SWRConfig } from "swr"

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'ICS Network',
  description: 'social network for ICS students',
}

export default function App() {
  return (
    <SWRConfig value={{
      fetcher: (resource, init = null) => fetch(resource, init).then(res => res.json()),
    }}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/posts/:id" element={<Postpage />} />
        </Routes>
      </BrowserRouter>
    </SWRConfig>
  )
}
