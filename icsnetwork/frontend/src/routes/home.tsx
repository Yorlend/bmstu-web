import { Post } from "@/components/post"
import { usePosts } from "@/lib/post"
import RootLayout from "@/routes/layout"

export function Homepage() {
  const { data: posts, error, isLoading } = usePosts()

  return (
    <RootLayout>
      <div className="inline-flex flex-col items-center justify-between my-10">
        <div className="[-webkit-text-stroke:1px_#000000] [font-family:'Roboto-CondensedBold',Helvetica] font-bold text-black text-[48px] tracking-[0] leading-[normal] whitespace-nowrap border-variable-collection-strokecolor text-center">
          ПУБЛИКАЦИИ <br className="md:hidden" /> ПОЛЬЗОВАТЕЛЕЙ
        </div>
      </div>

      <div className="mt-10 flex flex-col justify-center
        mx-10 items-stretch
        lg:mx-0 lg:items-center">
        {isLoading ? <p>Loading...</p> :
          error ? <p>Error: {error}</p> :
            posts!.toReversed().map((post) => <Post key={post.id} post={post} linkEnabled={true} />)}
      </div>
    </RootLayout>
  )
}
