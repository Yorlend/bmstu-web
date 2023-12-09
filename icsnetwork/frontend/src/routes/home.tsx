import { Post } from "@/components/post"
import { usePosts } from "@/lib/post"
import RootLayout from "@/routes/layout"

export function Homepage() {
  const { data: posts, error, isLoading } = usePosts()

  return (
    <RootLayout>
      <div className="inline-flex flex-col items-center justify-between my-10">
        <div className="[-webkit-text-stroke:1px_#000000] [font-family:'Roboto-CondensedBold',Helvetica] font-bold text-black text-[48px] tracking-[0] leading-[normal] whitespace-nowrap border-variable-collection-strokecolor">
          ПУБЛИКАЦИИ ПОЛЬЗОВАТЕЛЕЙ
        </div>
      </div>

      <div className="mt-10 flex flex-col items-center justify-center">
        {isLoading ? <p>Loading...</p> :
          error ? <p>Error: {error}</p> :
            posts!.map((post) => <Post key={post.id} post={post} linkEnabled={true} />)}
      </div>
    </RootLayout>
  )
}
