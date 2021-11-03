package exceptions

class MangaNotFoundException(val mangaId: Long) : RuntimeException("Манга с данным id: $mangaId не найдена")
