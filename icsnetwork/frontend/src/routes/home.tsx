import { Post } from "@/components/post"
import { getPosts } from "@/services/post-service"
import RootLayout from "@/routes/layout"
import { useEffect, useState } from "react"
import { Post as PostModel } from "@/domain/post"

export function Homepage() {
  const [posts, setPosts] = useState<PostModel[]>([])

  useEffect(() => void getPosts().then(setPosts), [])

  return (
    <RootLayout>
      <div className="inline-flex flex-col items-center justify-between my-10">
        <div className="[-webkit-text-stroke:1px_#000000] [font-family:'Roboto-CondensedBold',Helvetica] font-bold text-black text-[48px] tracking-[0] leading-[normal] whitespace-nowrap border-variable-collection-strokecolor">
          ПУБЛИКАЦИИ ПОЛЬЗОВАТЕЛЕЙ
        </div>
      </div>

      <div className="mt-10 flex flex-col items-center justify-center">
        {posts.map((post) => <Post key={post.id} post={post} linkEnabled={true} />)}
      </div>
    </RootLayout>
  )
}
