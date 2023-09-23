class Comments(val count: Int) {


    var can_post: Boolean = true
    var can_close: Boolean = true
    var can_open: Boolean = true

    constructor(
        count: Int,
        _can_post: Boolean,
        _can_close: Boolean,
        _can_open: Boolean,
    ) : this(count) {
        can_post = _can_post
        can_close = _can_close
        can_open = _can_open
    }

}