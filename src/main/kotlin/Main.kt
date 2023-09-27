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

    var post = Post(iD = 1,
        text = "text",
        Comments(1),
        Likes(1),
        date = 123345,
        friend_only = true,
        post_type = "ПОСТ",
        is_favorite = true,
         attachment = arrayOf(PhotoAttachment( Photo(1,"12223","text","TEXT"))))


    var post1: Post = Post(
        2,
        "textT",
        Comments(1),
        Likes(1),
        date = 12112022,
        attachment = arrayOf(VideoAttachment( Video(id = 1, photo_130 ="text" , photo_604 = "TEXT" ))))    // owner_id :  по дефолту прописан

    var post2: Post = Post(
        2,
        "textT",
        Comments(1),
        Likes(1),
        date = 12112022,
        attachment = arrayOf(AudioAttachment( Audio(1,"audio","text","TEXT"))))

    WallService.add(post)
    WallService.add(post1)
    WallService.add(post2)
    WallService.printPost()
    WallService.update(Post(1, "update",comments  = Comments(1,true,true,true), date = 12132022))
    WallService.printPost()
    PrintAttachment(post1)
}