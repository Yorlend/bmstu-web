import Image from "next/image"
import RootLayout from "./layout"
import NextArrowImage from '@/images/next-arrow.svg'
import { Link, useNavigate } from "react-router-dom"
import { useRef } from "react"
import { uploadPost } from "@/lib/post"
import { useAuth } from "@/auth/context"

export default function NewPostPage() {
  const titleRef = useRef<HTMLInputElement>(null)
  const contentRef = useRef<HTMLTextAreaElement>(null)

  const { auth } = useAuth()

  const navigator = useNavigate()

  async function onSubmit(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault()
    const title = titleRef.current!.value
    const content = contentRef.current!.value
    await uploadPost(title, content, auth!.token)
    navigator("/")
  }

  return (
    <RootLayout>
      <div className="inline-flex flex-col items-center justify-between my-10">
        <div className="[-webkit-text-stroke:1px_#000000] [font-family:'Roboto-CondensedBold',Helvetica] font-bold text-black text-[48px] tracking-[0] leading-[normal] whitespace-nowrap border-variable-collection-strokecolor">
          СОЗДАНИЕ ПУБЛИКАЦИИ
        </div>
      </div>
      <form className="mx-auto p-5 w-[1010px] bg-[#d9d9d9] rounded-[30px] shadow-[0px_10px_50px_#00000040]" onSubmit={onSubmit}>
        <div className="flex flex-row items-center justify-between mb-5">
          <div className="flex flex-row items-center gap-4">
            <input ref={titleRef} className="p-4 rounded-[30px] border border-solid border-variable-collection-strokecolor font-2 font-[number:var(--2-font-weight)] [font-style:var(--2-font-style)] text-black text-[length:var(--2-font-size)] tracking-[var(--2-letter-spacing)] leading-[var(--2-line-height)] whitespace-nowrap" type="text" placeholder="Название публикации" />
          </div>
          <button onClick={() => { }} className="flex items-center justify-center bg-secondarya rounded-[15px]">
            <span className="p-4 font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-variable-collection-menu-font text-[length:var(--regular-text-font-size)] tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)] whitespace-nowrap">
              опубликовать
            </span>
            <Image alt="Layer" src={NextArrowImage} />
          </button>
        </div>
        <textarea ref={contentRef} className="w-[100%] flex flex-wrap items-start gap-[10px_10px] p-5 rounded-[30px] border border-solid border-variable-collection-strokecolor font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] text-justify tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]" placeholder="Текст">
        </textarea>
      </form>
    </RootLayout>
  )
}
