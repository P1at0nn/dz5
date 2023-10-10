import java.util.Objects
import kotlin.coroutines.coroutineContext

object WallService {
    var posts = emptyArray<Post>()
    var comments = emptyArray<Comments>()
    var reportComment = emptyArray<Report>()
    var lastID = 0


     fun clear(){
         posts = emptyArray()
         comments = emptyArray()
         reportComment = emptyArray()
         lastID = 0
     }
    fun add(post: Post): Post {

        posts += post.copy(iD = ++lastID)
        return posts.last()
    }

    fun update(newpost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.iD == newpost.iD) {
                posts[index] = newpost.copy()

                return true
            }
        }

        return false
    }


    fun printPost() {
        for (post in posts) println(post)
    }

    fun printComment() {
        for (comment in comments) println(comment)
    }

    fun createComment(postID: Int, comments: Comments): Comments {
        for ((index, post) in posts.withIndex()) {

            if (post.iD == postID) {

                WallService.comments += comments

                return comments
            }
        }
        throw PostNotFoundException("пост с данным id не найден")
    }


    fun reportComment(report: Report): Int {        // жалоба

        for ((index, comment) in comments.withIndex()) {

            if (comment.id == report.comment_id) {
                if (report.reason in 0..8 && report.reason != 7) {
                    WallService.reportComment += report
                    println("жалоба добавлена ")

                    when (report.reason) {
                        0 -> println("спам")
                        1 -> println("детская порнография")
                        2 -> println("экстремизм")
                        3 -> println("насилие")
                        4 -> println("пропаганда наркотиков")
                        5 -> println("материал для взрослых")
                        6 -> println(" оскорбление")
                        8 -> println("призывы к суициду")
                    }
                    return 1
                } else throw ReasonNotFoundException("неверная причина жалабы (reason)")
            }

        }
        throw IdNotFoundException("неверный ID")
    }

}

fun main() {
//
//    var post = Post(
//        iD = 2,
//        text = "text",
//        Comments(1),
//        Likes(1),
//        date = 123345,
//        friend_only = true,
//        post_type = "ПОСТ",
//        is_favorite = true,
//        attachment = arrayOf(PhotoAttachment(Photo(1, "12223", "text", "TEXT")))
//    )
//
//
//    var post1: Post = Post(
//        222,
//        "textT",
//        Comments(2),
//        Likes(1),
//        date = 12112022,
//        attachment = arrayOf(VideoAttachment(Video(id = 1, photo_130 = "text", photo_604 = "TEXT")))
//    )    // owner_id :  по дефолту прописан

//    var post2: Post = Post(
//        2,
//        "textT",
//        Comments(1),
//        Likes(1),
//        date = 12112022,
//        attachment = arrayOf(AudioAttachment( Audio(1,"audio","text","TEXT"))))

    //println(WallService.add(post))
//     WallService.add(post1)
//    //  WallService.add(post2)
//    //   WallService.printPost()
//    //  WallService.update(Post(1, "update",comments  = Comments(1,true,true,true), date = 12132022))
//    WallService.printPost()
//    //   PrintAttachment(post1)
//    println("`1````````````````````````````````````````````")
    // println( WallService.createComment(1, comments = Comments(33, 1234, 120122023, arrayOf(VideoAttachment(Video(1, "Video", "http:", "http:"))))
    //))
//    //  WallService.printPost()
//    println("`````````````````````````````````````````````")
//    WallService.printComment()
//    println("`````````````````````````````````````````````")
    // WallService.printPost()
    //   println("`4````````````````````````````````````````````")
    // println(WallService.comments[0])

    //println(WallService.reportComment(report = Report(33, 33, 5)))// передаем созданную жалобу

    // println(WallService.reportComment[0])

}
