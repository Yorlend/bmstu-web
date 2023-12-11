import { useRef } from "react"
import { postComment } from "@/lib/comment"
import { useAuth } from "@/auth/context"
import { Comment } from "@/domain/comment"

interface Props {
  postId: number
  onSubmit?: (comment: Comment) => void
}

export default function CommentForm({ postId, onSubmit }: Props): React.ReactElement {
  const inputRef = useRef<HTMLInputElement>(null)

  const { auth } = useAuth()

  async function formAction(event: React.FormEvent<HTMLFormElement>) {
    event.preventDefault()
    const content = inputRef.current!.value 
    if (content !== undefined && content != "") {
      const comment = await postComment(postId, content, auth!.token)
      inputRef.current!.value = ""
      onSubmit?.(comment)
    }
  }

  return (
    <form onSubmit={formAction}>
      <div className="lg:w-[1010px] flex flex-col md:flex-row items-stretch md:items-center justify-stretch gap-5 md:gap-10 mb-10">
        <input ref={inputRef} className="md:grow w-fill px-6 py-4 bg-[#d9d9d9] rounded-[20px] font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] text-justify tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]" type="text" name="content" autoComplete="off" />
        <button className="px-6 py-4 bg-secondaryb font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)] rounded-[20px]" type="submit">
          Отправить комментарий
        </button>
      </div>
    </form>
  )
}
