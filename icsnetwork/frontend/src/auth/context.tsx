import { User } from "@/domain/user"
import { jwtDecode } from "jwt-decode"
import { Dispatch, SetStateAction, createContext, useContext, useState } from "react"

interface Auth {
  user: User
  token: string
}

interface AuthContextPayload {
  auth: Auth | null
  setAuth: Dispatch<SetStateAction<Auth | null>>
}

const AuthContext = createContext<AuthContextPayload>({ auth: null, setAuth: () => { } })

interface Props {
  children: React.ReactNode
}

export default function AuthProvider({ children }: Props): React.ReactElement {
  const defaultAuth = localStorage.getItem('auth') ? JSON.parse(localStorage.getItem('auth')!) : null

  const [auth, setAuth] = useState<Auth | null>(defaultAuth)

  function setAuthWrapper(auth: Auth | null) {
    localStorage.setItem('auth', JSON.stringify(auth))
    setAuth(auth)
  }

  const payload = { auth, setAuth: setAuthWrapper } as AuthContextPayload

  return (
    <AuthContext.Provider value={payload}>
      {children}
    </AuthContext.Provider>
  )
}

export function useAuth(): AuthContextPayload {
  return useContext(AuthContext)
}

export async function authenticate(login: string, password: string): Promise<Auth | Error> {
  let response = await fetch(`http://localhost:8080/api/v1/users/login`, {
    method: 'post',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({
      username: login,
      password: password,
    }),
  })
  const data = await response.json()
  if ('message' in data) {
    return Error(data.message)
  }

  const token = jwtDecode(data.token)
  const userId = token.sub

  response = await fetch(`http://localhost:8080/api/v1/users/${userId}`)
  const user = await response.json() as User
  return { user, token: data.token }
}
