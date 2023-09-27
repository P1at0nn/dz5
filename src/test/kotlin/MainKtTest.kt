import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun add() {
        val postnew = Post(iD=0, text = "qwer", comments = Comments(1), Likes(1),null)
        val postnew1 = Post(iD=0, text = "qwer", comments = Comments(1), Likes(1),null)
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
        assertFalse(result)

    }
}