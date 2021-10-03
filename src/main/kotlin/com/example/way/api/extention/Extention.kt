package com.example.way.api.extention

fun String.toSlug() = lowercase()
        .replace("\n", " ")
        .replace("[^a-z\\d\\s]".toRegex(), " ")
        .split(" ")
        .joinToString("-")
        .replace("-+".toRegex(), "-")

fun cyr2lat(ch: Char): String {
    return when (ch) {
        'А' -> "A"
        'Б' -> "B"
        'В' -> "V"
        'Г' -> "G"
        'Д' -> "D"
        'Е' -> "E"
        'Ё' -> "JE"
        'Ж' -> "ZH"
        'З' -> "Z"
        'И' -> "I"
        'Й' -> "Y"
        'К' -> "K"
        'Л' -> "L"
        'М' -> "M"
        'Н' -> "N"
        'О' -> "O"
        'П' -> "P"
        'Р' -> "R"
        'С' -> "S"
        'Т' -> "T"
        'У' -> "U"
        'Ф' -> "F"
        'Х' -> "KH"
        'Ц' -> "C"
        'Ч' -> "CH"
        'Ш' -> "SH"
        'Щ' -> "JSH"
        'Ъ' -> "HH"
        'Ы' -> "IH"
        'Ь' -> "JH"
        'Э' -> "EH"
        'Ю' -> "JU"
        'Я' -> "JA"
        else -> ch.toString()
    }
}

fun String.cyr2lat(): String {
    val sb = StringBuilder(this.length * 2)
    for (ch in this.toCharArray()) {
        sb.append(cyr2lat(ch))
    }
    return sb.toString()
}