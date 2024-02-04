package kr.pokeum.jsonviewer_compose.ui.values

internal class Strings {

    companion object {
        val JSON_KEY_LABEL by lazy { "key" }
        val JSON_OBJECT_KEY_DESCRIPTION_LABEL by lazy { "{ }" }
        val JSON_ARRAY_KEY_DESCRIPTION_LABEL by lazy { "[ ]" }
        val JSON_NUMBER_KEY_DESCRIPTION_LABEL by lazy { "123" }
        val JSON_STRING_KEY_DESCRIPTION_LABEL by lazy { "ABC" }
        val JSON_BOOLEAN_KEY_DESCRIPTION_LABEL by lazy { "T/F" }
        val JSON_NULL_KEY_DESCRIPTION_LABEL by lazy { "?" }

        val JSON_NULL by lazy { "NULL" }
        val JSON_SPLITTER by lazy { " : " }

        val JSON_ARROW_ICON_DESCRIPTION by lazy { "Json Arrow Icon" }
    }
}