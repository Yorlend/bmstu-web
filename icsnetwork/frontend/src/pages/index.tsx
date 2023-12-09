import AuthProvider from "@/auth/context"
import AuthPage from "@/routes/auth"
import { Homepage } from "@/routes/home"
import NewPostPage from "@/routes/new-post"
import PostPage from "@/routes/post"
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
      <AuthProvider>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Homepage />} />
            <Route path="/login" element={<AuthPage />} />
            <Route path="/posts/:id" element={<PostPage />} />
            <Route path="/new-post" element={<NewPostPage />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
    </SWRConfig>
  )
}
