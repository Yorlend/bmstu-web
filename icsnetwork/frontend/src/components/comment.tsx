import { useAuth } from '@/auth/context'
import { Comment } from '@/domain/comment'
import UserImage from '@/images/user.svg'
import TrashCanImage from '@/images/trash-can.svg'
import Image from 'next/image'

interface Props {
  comment: Comment
  onDelete?: (comment: Comment) => void
}

export function Comment({ comment, onDelete }: Props): React.ReactElement {
  const { auth } = useAuth()

  return (
    <div className="w-[1011px] mb-6 flex flex-row items-center justify-stretch gap-6 px-6 py-4 bg-[#d9d9d9] rounded-[30px]">
      <Image className="w-[100px] h-[100px]" alt="Usericon" src={UserImage} />
      <div className="w-[100%] inline-flex flex-col items-start">
        <div className="w-[100%] flex flex-row items-center justify-between">
          <p className="mb-5 font-semibold [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]">
            {comment.author.name}
          </p>
          {auth !== null && auth.user.id === comment.author.id &&
            <button onClick={() => onDelete?.(comment)} className="p-2 rounded-[15px] font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-white text-[length:var(--regular-text-font-size)] text-justify tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)] bg-secondarya">
              <Image width={40} src={TrashCanImage} alt="Trashcan" />
            </button>}
        </div>
        <p className="font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] text-justify tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]">
          {comment.content}
        </p>
      </div>
    </div>
  )
}
