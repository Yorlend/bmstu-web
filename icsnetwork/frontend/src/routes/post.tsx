import { Comment } from "@/components/comment"
import CommentForm from "@/components/comment-form"
import { Post } from "@/components/post"
import { getPost } from "@/services/post-service"
import { Post as PostModel } from "@/domain/post"
import RootLayout from "./layout"
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"


export default function Postpage(): React.ReactElement {
  const { id: postId } = useParams() as { id: string }

  const [postInfo, setPostInfo] = useState<PostModel | null>(null)

  // page rerender trigger
  const [commentSent, sendComment] = useState({})

  useEffect(() => void getPost(parseInt(postId)).then(setPostInfo), [postId, commentSent])

  return (
    <RootLayout>
      {postInfo &&
        <div className="mt-10 flex flex-col items-center justify-center">
          <Post post={postInfo} />
          <CommentForm postId={postInfo.id!} onSubmit={() => sendComment({})} />
          {postInfo.comments?.map((comment) => <Comment key={comment.id} comment={comment} />)}
        </div>
      }
    </RootLayout>
  )
}
