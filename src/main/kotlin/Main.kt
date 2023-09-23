import java.util.Objects
import kotlin.coroutines.coroutineContext

object WallService {
    var posts = emptyArray<Post>()
    var lastID = 0

    fun add(post: Post): Post {

        posts += post.copy(iD = ++lastID)
        return posts.last()
    }

    fun update(newpost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.iD == newpost.iD) {
                posts[index] = newpost.copy()
                println("tryy")
                return true
            }
        }

        return false
    }


    fun printPost() {
        for (post in posts) println(post)
    }
}


fun main() {

    var post: Post = Post(
        iD = 1,
        text = "text",
        Comments(1),

        Likes(1),

        date = 123345,
        friend_only = true,
        post_type = "ПОСТ",
    )

    var post1: Post = Post(
        2,
        "textT",
        Comments(1),
        Likes(1),
    )

    WallService.add(post)
    WallService.add(post1)
    WallService.printPost()
    WallService.update(Post(1, "update"))
    WallService.printPost()
}