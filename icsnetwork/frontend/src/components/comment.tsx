import { Comment } from '@/domain/comment'
import UserImage from '@/images/user.svg'
import Image from 'next/image'

interface Props {
  comment: Comment
}

export function Comment({ comment }: Props): React.ReactElement {
  return (
    <div className="w-[1011px] mb-6 flex flex-row items-center justify-stretch gap-6 px-6 py-4 bg-[#d9d9d9] rounded-[30px]">
      <Image className="w-[100px] h-[100px]" alt="Usericon" src={UserImage} />
      <div className="inline-flex flex-col items-start">
        <p className="mb-5 font-semibold [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]">
          {comment.author.name}
        </p>
        <p className="font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] text-justify tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]">
          {comment.content}
        </p>
      </div>
    </div>
  )
}
