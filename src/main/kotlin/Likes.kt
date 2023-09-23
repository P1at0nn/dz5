class Likes constructor(val count: Int, val user_likes: Boolean = true) {
    var can_like = true
    var can_publish = true

    constructor(
        count: Int,
        user_likes: Boolean,
        _can_like: Boolean,
        _can_publish: Boolean,

        ) : this(count, user_likes) {
        can_like = _can_like
        can_publish = _can_publish
    }


}