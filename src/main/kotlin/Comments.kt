data class Comments(
     val id: Int, val from_ID: Int?=null, val date: Int? = null,
    val attachment: Array<Attachment> = emptyArray()
)