package ru.icsnetwork.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRouting() {
    route("/api/v1/users") {
        get {
            call.respond(mapOf("hello" to "world"))
        }

        get("{id?}") {

        }

        post {

        }

        delete("{id?}") {

        }
    }
}