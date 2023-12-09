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

export async function uploadPost(title: string, content: string, token: string): Promise<Post> {
  const response = await fetch(`http://localhost:8080/api/v1/posts`, {
    method: 'post',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
    body: JSON.stringify({
      title: title,
      content: content,
    }),
  })
  const data = await response.json()
  return data
}
