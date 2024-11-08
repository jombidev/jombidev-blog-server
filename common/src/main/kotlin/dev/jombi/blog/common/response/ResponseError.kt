package dev.jombi.blog.common.response

import dev.jombi.blog.common.exception.ExceptionDetail
import kotlinx.serialization.Serializable
import org.springframework.http.ResponseEntity

@Serializable
class ResponseError(override val code: String, override val status: Int, @Suppress("unused") val detail: String) :
    BaseResponse {
    companion object {
        fun of(message: ExceptionDetail, vararg args: Any?) =
            ResponseEntity
                .status(message.status)
                .body(ResponseError(message.code, message.status.value(), message.message.format(*args)))
    }
}
