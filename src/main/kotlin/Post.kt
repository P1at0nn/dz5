import com.sun.xml.internal.ws.api.message.AttachmentEx

data class Post(
    var iD: Int,
    val text: String? = null,
    var comments: Comments?=null,
    var likes: Likes? = null,
    val date: Int?=null ,//=11012011,
    val friend_only: Boolean? = null,
    val post_type: String? = null,
    val is_favorite: Boolean? = null,
    val attachment :Array<Attachment> = emptyArray()
)
 interface Attachment{

    val type : String


}
data class AudioAttachment(
    val audio: Audio

):Attachment{
    override val type: String ="audio"

}
data class Audio(
    val id:Int,
    val owner_id:String,
    val photo_130:String,
    val photo_604:String
){

}
data class PhotoAttachment(

    val photo : Photo,


):Attachment{
    override val type: String = "photo"


}
data class Photo(
    val id:Int,
    val owner_id:String,
    val photo_130:String,
    val photo_604:String

){
}
data class VideoAttachment(
    val video: Video
):Attachment{
    override val type: String = "video"

}
data class Video(
    val id:Int,
    val owner_id:String="defoult STRING",
    val photo_130:String,
    val photo_604:String

)
data class DocAttachment(
    val doc:Doc
):Attachment{
    override  val type :String = "doc"
}
data class Doc(
    val id:Int,
    val owner_id:String,
    val photo_130:String,
    val photo_604:String
)
data class NoteAtachment(
    val note:Note
):Attachment{
    override  val   type:String ="note"
}
data class Note(
    val id:Int,
    val owner_id:String,
    val photo_130:String,
    val photo_604:String
)
data class EventAtachment(
    val event:Event
):Attachment{
    override val type:String ="event"
}
data class Event(
    val id:Int,
    val time:Int,
    val address:String,
    val text:String,
    val is_favorite: Boolean
)



