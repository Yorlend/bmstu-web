import { Comment } from "@/components/comment"
import CommentForm from "@/components/comment-form"
import { Post } from "@/components/post"
import { usePost } from "@/lib/post"
import { Post as PostModel } from "@/domain/post"
import RootLayout from "./layout"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"


export default function Postpage(): React.ReactElement {
  const { id: postId } = useParams() as { id: string }
  const { data: post, error, isLoading } = usePost(parseInt(postId))

  // page rerender trigger
  const [commentSent, sendComment] = useState({})

  return (
    <RootLayout>
      {isLoading ? <p>Loading...</p> :
        error ? <p>Error: {error}</p> :
          <div className="mt-10 flex flex-col items-center justify-center">
            <Post post={post!} />
            <CommentForm postId={post!.id!} onSubmit={() => sendComment({})} />
            {post!.comments?.map((comment) => <Comment key={comment.id} comment={comment} />)}
          </div>
      }
    </RootLayout>
  )
}
