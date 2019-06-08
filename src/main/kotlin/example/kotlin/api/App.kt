package example.kotlin.api

import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.server.SunHttp
import org.http4k.server.asServer

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

fun main(args: Array<String>) {
    routes("/hello" bind Method.GET to { _: Request -> Response(OK).body(App().greeting) })
            .asServer(SunHttp(8000))
            .start()
}
