package exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

class MangaNotFoundException(val mangaId: Long) : RuntimeException("Манга с данным id: $mangaId не найдена")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class UsernameUnavailableException(val username: String): RuntimeException()
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
class EmailUnavailableException(val username: String): RuntimeException()