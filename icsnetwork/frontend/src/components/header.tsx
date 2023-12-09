import Image from "next/image"
import React from "react"
import EnotImage from '@/images/enot.png'
import StudentImage from '@/images/student.svg'
import { Link } from "react-router-dom"

export default function Header(): React.ReactElement {
  return (
    <header>
      <Image className="w-screen h-[400px]" alt="Header bg" src={EnotImage} />
      <div className="flex w-[906px] items-center justify-center absolute top-6 shadow-[0px_16px_102.6px_#63256033] left-1/2 transform -translate-x-1/2">
        <div className="inline-flex flex-row items-center justify-center">
          <Image className="w-[50px] h-[50px]" alt="Student icon" src={StudentImage} />
          <div className="font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] [font-style:var(--menu-font-style)]">
            ICSNetwork
          </div>
        </div>
        <div className="grow"></div>
        <div className="mx-3 font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] whitespace-nowrap relative tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] [font-style:var(--menu-font-style)]">
          Создать пост
        </div>
        <Link to="/" className="mx-3 font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] whitespace-nowrap relative tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] [font-style:var(--menu-font-style)]">
          Главная
        </Link>
        <div className="ml-3 px-5 py-3 bg-secondarya">
          <div className="font-menu font-[number:var(--menu-font-weight)] text-variable-collection-menu-font text-[length:var(--menu-font-size)] tracking-[var(--menu-letter-spacing)] leading-[var(--menu-line-height)] whitespace-nowrap [font-style:var(--menu-font-style)]">
            Войти
          </div>
        </div>
      </div>
    </header>
  )
}
