import Image from "next/image"
import NextArrow from "@/images/next-arrow.svg"
import { Post } from "@/domain/post"
import { Link } from "react-router-dom"

interface Props {
  post: Post
  linkEnabled?: boolean
}

export function Post({ post, linkEnabled }: Props): JSX.Element {
  return (
    <div className="mb-10 w-[1010px] bg-[#d9d9d9] rounded-[30px] shadow-[0px_10px_50px_#00000040]">
      <div className="flex flex-row items-center justify-between p-5">
        <div className="flex flex-row items-center gap-4">
          <div className="p-4 rounded-[30px] border border-solid border-variable-collection-strokecolor font-2 font-[number:var(--2-font-weight)] [font-style:var(--2-font-style)] text-black text-[length:var(--2-font-size)] tracking-[var(--2-letter-spacing)] leading-[var(--2-line-height)] whitespace-nowrap">
            {post.title}
          </div>
          <div className="font-2 font-[number:var(--2-font-weight)] [font-style:var(--2-font-style)] text-black text-[length:var(--2-font-size)] tracking-[var(--2-letter-spacing)] leading-[var(--2-line-height)] whitespace-nowrap">
            {post.author?.name || "Аноним"}
          </div>
        </div>
        {linkEnabled &&
          <Link to={`/posts/${post.id}`} className="flex items-center justify-center bg-secondarya rounded-[15px]">
            <span className="p-4 font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-variable-collection-menu-font text-[length:var(--regular-text-font-size)] tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)] whitespace-nowrap">
              к посту
            </span>
            <Image alt="Layer" src={NextArrow} />
          </Link>
        }
      </div>
      <div className="flex flex-wrap items-start gap-[10px_10px] p-5 m-5 rounded-[30px] border border-solid border-variable-collection-strokecolor">
        <p className="flex-1 self-stretch font-regular-text font-[number:var(--regular-text-font-weight)] [font-style:var(--regular-text-font-style)] text-black text-[length:var(--regular-text-font-size)] text-justify tracking-[var(--regular-text-letter-spacing)] leading-[var(--regular-text-line-height)]">
          {!!post.content ? post.content : `Не следует, однако, забывать, что консультация с широким активом играет определяющее значение для
            благоприятных перспектив. Прежде всего, курс на социально-ориентированный национальный проект создаёт
            предпосылки для вывода текущих активов. Прежде всего, экономическая повестка сегодняшнего дня не даёт нам
            иного выбора, кроме определения поэтапного и последовательного развития общества. Мы вынуждены отталкиваться
            от того, что современная методология разработки в значительной степени обусловливает важность кластеризации
            усилий.`}
        </p>
      </div>
    </div>
  );
};
