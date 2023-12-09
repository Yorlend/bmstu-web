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
      <div className="w-[1010px] flex flex-row items-center justify-stretch gap-10 mb-10">
        <input ref={inputRef} className="grow w-fill px-6 py-4 bg-[#d9d9d9] rounded-[30px] font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] text-justify tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]" type="text" name="content" autoComplete="off" />
        <button className="px-6 py-4 bg-secondaryb font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]" type="submit">
          Отправить комментарий
        </button>
      </div>
    </form>
  )
}
