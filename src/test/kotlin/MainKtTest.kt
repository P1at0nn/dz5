import org.junit.Test

import org.junit.Assert.*
import kotlin.test.expect

class MainKtTest {

    @Test
    fun add() {
        val postnew = Post(iD = 0, text = "qwer", comments = Comments(1), Likes(1), null)
        val postnew1 = Post(iD = 0, text = "qwer", comments = Comments(1), Likes(1), null)
        WallService.add(postnew)
        WallService.add(postnew1)
        val result =
            WallService.posts.get(0)// нужно вытащить из массива так как он не меняет старый , а копирует с заменой
        assertEquals(1, result.iD)
    }


    @Test
    fun update() {
        val service = WallService
        service.add(Post(1, "text"))
        service.add(Post(2, "text2"))
        service.add(Post(3, "text3"))
        val update = service.update(Post(1, "NEW_text!!!!"))
        val result: Boolean = update

        assertTrue(result)

    }

    @Test
    fun NOupdate() {
        val service = WallService
        service.add(Post(1, "text"))
        service.add(Post(2, "text2"))
        service.add(Post(3, "text3"))
        val update = WallService.update(Post(6, "NEW_text!!!!"))
        println(update)
        val result: Boolean = update
        assertTrue(result)

    }

    @Test
    fun createCommentTrue() {
        val service = WallService
        service.add(Post(1, "text"))
        val comments: Comments = Comments(1, 123)
      //  val comments1: Comments = Comments(4, 123)
        val create = WallService.createComment(1, comments)

        println(create)
        val result: Comments = create

        assertEquals(comments, result)
    }



    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService
        service.add(Post(2, "text"))
        val comments: Comments = Comments(1, 123)
       // val comments1: Comments = Comments(4, 123)
        WallService.createComment(4, comments)


    }
    @Test(expected = IdNotFoundException::class)
    fun shouldThrow2() {
        val service = WallService
       // println( WallService.lastID)
        service.add(Post(1, "text"))
        //println(WallService.lastID)
        val comments: Comments = Comments(1, 123)
        WallService.createComment(1, comments)
        val report:Report = Report(1,3,1)
        WallService.reportComment(report)


    }
    @Test(expected = ReasonNotFoundException::class)
    fun shouldThrow3() {
        val service = WallService
        service.add(Post(1, "text"))
        val comments: Comments = Comments(4, 123)

        WallService.createComment(1, comments)
        val report:Report = Report(1,4,12)
        WallService.reportComment(report)


    }


}