import com.blannon_network.module
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals


class ApplicationTest {
    @Test
    fun testRoot()= testApplication{
        application {
            module()
        }

        val response = client.get("/test")
        assertEquals(HttpStatusCode.OK, response.status)

        assertEquals("html", response.contentType()?.contentSubtype)
        assertContains(
            response.bodyAsText(),
            "<h1>Hello From Blannon_Network</h1>")

    }

}