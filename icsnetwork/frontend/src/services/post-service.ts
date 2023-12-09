import { Post } from "@/domain/post"

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

interface PostsResponse {
  posts: PostResponse[]
}

export async function getPosts(): Promise<Post[]> {
  const response = await fetch(`http://localhost:8080/api/v1/posts`)
  console.log(response)
  const data: PostsResponse = await response.json()
  return data.posts.map(p => ({
    id: p.id,
    title: p.title,
    content: p.content,
    author: p.user,
  } as Post))
}

export async function getPost(postId: number): Promise<Post> {
  const response = await fetch(`http://localhost:8080/api/v1/posts/${postId}`)
  const post: PostResponse = await response.json()
  const response2 = await fetch(`http://localhost:8080/api/v1/posts/${postId}/comments`)
  const comments = await response2.json()

  // mock single comment
  comments.comments.push({
    id: 1,
    content: "Комментарий",
    author: {
      name: "Аноним1",
      id: 1
    }
  })

  return {
    id: post.id,
    title: post.title,
    content: post.content,
    author: post.user,
    ...comments,
  } as Post
}
