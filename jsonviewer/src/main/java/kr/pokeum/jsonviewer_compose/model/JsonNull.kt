package kr.pokeum.jsonviewer_compose.model

class JsonNull(override val key: String) : JsonElement {

    override fun toString(): String { return NULL }

    companion object {
        private const val NULL = "null"
    }
}