package com.blannon_network

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(StatusPages){
        exception<IllegalStateException>{call, cause ->
            call.respondText("App in illegal State as ${cause.message}")
        }
    }

    routing {

        staticResources("/content", "mycontent")
        get("/") {
            call.respondText("Hello World!")
        }

        get("/error-test"){
            throw IllegalStateException("Too Busy")
        }

        get("/test") {
            val  text = "<h1> Hello From Blannon_Network</h1>"
            val type = ContentType.parse("text/html")
            call.respondText(text, type)
        }
    }
}
