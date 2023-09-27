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
 sealed class Attachment()
data class AudioAttachment(
    val audio: Audio

):Attachment(){
     val type: String ="audio"

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


):Attachment(){
     val type: String = "photo"


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
):Attachment(){
     val type: String = "video"

}
data class Video(
    val id:Int,
    val owner_id:String="defoult STRING",
    val photo_130:String,
    val photo_604:String

)
data class DocAttachment(
    val doc:Doc
):Attachment(){
      val type :String = "doc"
}
data class Doc(
    val id:Int,
    val owner_id:String,
    val photo_130:String,
    val photo_604:String
)
data class NoteAtachment(
    val note:Note
):Attachment(){
      val   type:String ="note"
}
data class Note(
    val id:Int,
    val owner_id:String,
    val photo_130:String,
    val photo_604:String
)
data class EventAtachment(
    val event:Event
):Attachment(){
     val type:String ="event"
}
data class Event(
    val id:Int,
    val time:Int,
    val address:String,
    val text:String,
    val is_favorite: Boolean
)


fun PrintAttachment(post:Post){

    var first = post.attachment[0]
    for (index in post.attachment.indices){
        var t = post.attachment[index]
        println(t)
        first  = t

    }

    when (first) {
        is  PhotoAttachment-> println("Фото")
        is VideoAttachment -> println( "Видео")
        is EventAtachment -> println("Встреча")
        is DocAttachment -> println("Документ")
        is NoteAtachment -> println("заметка")
        is AudioAttachment -> println("Аудио")
    }
}


