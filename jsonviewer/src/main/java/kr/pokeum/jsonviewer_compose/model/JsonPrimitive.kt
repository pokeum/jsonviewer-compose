package kr.pokeum.jsonviewer_compose.model

class JsonPrimitive private constructor(
    override val key: String
) : JsonElement {

    lateinit var value: Any
        private set

    constructor(key: String, value: Number) : this(key) { this.value = value }
    constructor(key: String, value: String) : this(key) { this.value = value }
    constructor(key: String, value: Boolean): this(key) { this.value = value }
}