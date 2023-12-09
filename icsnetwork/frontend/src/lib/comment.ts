import { Comment } from "@/domain/comment"

export async function postComment(postId: number, content: string, token: string): Promise<Comment> {
  const response = await fetch(`http://localhost:8080/api/v1/posts/${postId}/comments`, {
    method: 'post',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
    body: JSON.stringify({
      content: content
    }),
  })
  const data = await response.json()
  console.log('posted comment: ' + content)
  return data
}

export async function deleteComment(postId: number, commentId: number, token: string) {
  await fetch(`http://localhost:8080/api/v1/posts/${postId}/comments/${commentId}`, {
    method: 'delete',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`,
    },
  })
}
