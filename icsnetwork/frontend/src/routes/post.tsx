import { Comment } from "@/components/comment"
import CommentForm from "@/components/comment-form"
import { Post } from "@/components/post"
import { usePost } from "@/lib/post"
import RootLayout from "./layout"
import { useParams } from "react-router-dom"
import { useAuth } from "@/auth/context"
import { Comment as CommentModel } from '@/domain/comment'
import { deleteComment } from "@/lib/comment"


export default function Postpage(): React.ReactElement {
  const { id: postId } = useParams() as { id: string }
  const { data: post, error, isLoading, triggerReload } = usePost(parseInt(postId))

  const { auth } = useAuth()

  async function deleteCommentWrapper(comment: CommentModel) {
    await deleteComment(parseInt(postId), comment.id, auth!.token)
    triggerReload()
  }

  return (
    <RootLayout>
      {isLoading ? <p>Loading...</p> :
        error ? <p>Error: {error}</p> :
          <div className="mt-10 flex flex-col items-center justify-center">
            <Post post={post!} />
            {auth && <CommentForm postId={post!.id!} onSubmit={(comment) => triggerReload()} />}
            {post!.comments!.toReversed().map((comment) => <Comment key={comment.id} comment={comment} onDelete={deleteCommentWrapper} />)}
          </div>
      }
    </RootLayout>
  )
}

