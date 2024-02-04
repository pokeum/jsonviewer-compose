package kr.pokeum.app.util

import android.content.Context
import kr.pokeum.jsonviewer_compose.JsonParser
import kr.pokeum.jsonviewer_compose.model.JsonElement
import kr.pokeum.jsonviewer_compose.model.JsonObject
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

@Throws(IOException::class)
fun Context.readAssetsFile(filename: String): String {
    val inputStream: InputStream = assets.open(filename)
    val bufferedReader = BufferedReader(InputStreamReader(inputStream))
    val stringBuilder = StringBuilder()
    var line: String?
    while (bufferedReader.readLine().also { line = it } != null) {
        stringBuilder.append(line)
    }
    inputStream.close()
    return stringBuilder.toString()
}

fun Context.generateJsonElement(filename: String): JsonElement? {

    val jsonParser = JsonParser
        .Builder()
        .setComparator(compareBy { it !is JsonObject })
        .build()

    return try {
        jsonParser.parse(readAssetsFile(filename))
    }
    catch (e: JSONException) { null }
    catch (e: IOException) { null }
}