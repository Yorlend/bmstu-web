import Image from "next/image"
import React from "react"
import EnotImage from '@/images/enot.png'
import StudentImage from '@/images/student.svg'
import { Link } from "react-router-dom"
import { useAuth } from "@/auth/context"

export default function Header(): React.ReactElement {
  const { auth, setAuth } = useAuth()

  function logout() {
    setAuth(null)
  }

  return (
    <header>
      <Image className="w-screen h-fit md:h-[400px]" alt="Header bg" src={EnotImage} />
      <div className="flex w-screen flex-col items-center justify-center absolute top-6 shadow-[0px_16px_102.6px_#63256033] left-1/2 transform -translate-x-1/2
        gap-3
        md:w-[90%] md:flex-row md:mx-5 md:gap-0
        lg:w-[906px]">
        <div className="inline-flex flex-row items-center justify-center">
          <Image className="w-[50px] h-[50px]" alt="Student icon" src={StudentImage} />
          <div className="font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] [font-style:var(--menu-font-style)]">
            ICSNetwork
          </div>
        </div>
        <div className="grow"></div>
        {auth &&
          <Link to="/new-post" className="mx-3 font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] whitespace-nowrap relative tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] [font-style:var(--menu-font-style)]">
            Создать пост
          </Link>}
        <Link to="/" className="mx-3 font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] whitespace-nowrap relative tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] [font-style:var(--menu-font-style)]">
          Главная
        </Link>
        <div className="ml-3 px-5 py-3 bg-secondarya">
          {!auth ?
            <Link to="/login" className="font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] whitespace-nowrap [font-style:var(--menu-font-style)]">
              Войти
            </Link>
            :
            <button onClick={logout} className="font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] whitespace-nowrap [font-style:var(--menu-font-style)]">
              Выйти
            </button>
          }
        </div>
      </div>
    </header>
  )
}
