import { Post } from "@/domain/post"
import useSWR from "swr"

interface PostResponse {
  id: number
  title: string
  content: string
  user: {
    id: number
    name: string
    login: string
  }
}

export function usePosts() {
  let { data, error, isLoading } = useSWR(`http://localhost:8080/api/v1/posts`)

  if (data) {
    data = data.posts.map((p: PostResponse) => ({
      id: p.id,
      title: p.title,
      content: p.content,
      author: p.user,
    } as Post))
  }

  return { data, error, isLoading } as { data: Post[] | null, error: any, isLoading: boolean }
}

export function usePost(postId: number) {
  const { data: postInfo, error: postInfoError, isLoading: postInfoLoading } =
    useSWR(`http://localhost:8080/api/v1/posts/${postId}`)

  const { data: comments, error: commentsError, isLoading: commentsLoading, mutate } =
    useSWR(`http://localhost:8080/api/v1/posts/${postId}/comments`)

  let data: Post | null = null

  if (postInfo && comments) {
    // mock single comment
    // comments.comments.push({
    //   id: 1,
    //   content: "Комментарий",
    //   author: {
    //     name: "Аноним1",
    //     id: 1
    //   }
    // })

    data = {
      id: postInfo.id,
      title: postInfo.title,
      content: postInfo.content,
      author: postInfo.user,
      ...comments,
    } as Post
  }

  return {
    data,
    error: postInfoError || commentsError,
    isLoading: postInfoLoading || commentsLoading,
    triggerReload: () => {
      mutate()
    }
  }
}
