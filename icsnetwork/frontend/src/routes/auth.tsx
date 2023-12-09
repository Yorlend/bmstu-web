import Image from "next/image"
import RootLayout from "./layout"
import UserImage from '@/images/user.svg'
import LoginButtonImage from '@/images/login-buttom.svg'
import { useLayoutEffect, useRef } from "react"
import { authenticate, useAuth } from "@/auth/context"
import { useNavigate } from "react-router-dom"

export default function Authpage(): React.ReactElement {
  const navigation = useNavigate()
  const loginRef = useRef<HTMLInputElement>(null)
  const passwordRef = useRef<HTMLInputElement>(null)
  const { auth, setAuth } = useAuth()

  useLayoutEffect(() => {
    if (auth !== null) {
      navigation("/")
    }
  }, [auth, navigation])

  async function onSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault()
    const login = loginRef.current!.value
    const password = passwordRef.current!.value

    const res = await authenticate(login, password)
    if (!(res instanceof Error)) {
      setAuth(res)      
    }
    console.log(res)
  }

  return (
    <RootLayout>
      <form className="flex flex-col gap-5 mx-auto my-8 p-5 bg-[#d9d9d9] rounded-[30px]" onSubmit={onSubmit}>
        <div className='flex items-center justify-center gap-[10px]'>
          <Image className="h-[100px]" alt="Usericon" src={UserImage} />
          <div className="font-1 font-[number:var(--1-font-weight)] text-black text-[length:var(--1-font-size)] tracking-[var(--1-letter-spacing)] leading-[var(--1-line-height)] whitespace-nowrap [font-style:var(--1-font-style)]">
            ВХОД
          </div>
        </div>
        <input ref={loginRef} className="w-[360px] h-[116px] p-[30px] rounded-[20px] border border-solid border-variable-collection-strokecolor font-1 font-[number:var(--1-font-weight)] text-black text-[length:var(--1-font-size)] tracking-[var(--1-letter-spacing)] leading-[var(--1-line-height)] whitespace-nowrap [font-style:var(--1-font-style)]" placeholder="ЛОГИН" type="text" name="login" />
        <input ref={passwordRef} className="w-[360px] h-[116px] p-[30px] rounded-[20px] border border-solid border-variable-collection-strokecolor font-1 font-[number:var(--1-font-weight)] text-black text-[length:var(--1-font-size)] tracking-[var(--1-letter-spacing)] leading-[var(--1-line-height)] whitespace-nowrap [font-style:var(--1-font-style)]" placeholder="ПАРОЛЬ"  type="password" name="password" />
        <button className="w-[120px] h-[80px] flex items-center justify-center place-self-end bg-secondarya rounded-[20px]" type="submit">
          <Image alt="Login btn" src={LoginButtonImage} />
        </button>
      </form>
    </RootLayout>
  )
}
