data class Post(
    var iD: Int,
    val text: String = "text",
    var comments: Comments = Comments(1),
    var likes: Likes = Likes(1),
    val date: Int = 1122023,
    val friend_only: Boolean = true,
    val post_type: String = "post_type",
    val is_favorite: Boolean = true
)




