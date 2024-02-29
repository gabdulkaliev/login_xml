package com.example.figma_login_xml
//
//import com.squareup.moshi.Json
//import com.squareup.moshi.Moshi
//import okhttp3.OkHttpClient
//import okhttp3.Request
//
data class Contact(
    val fullName: String,
    val number: String,
    val avatarUrl: String
)
fun getContact(): Contact? {
    val apiKey = "your_api_key" // Замените на ваш ключ API от randomdatatools.ru

    val (_, response, result) = Fuel.get("https://randomdatatools.ru/api/v1/data?api_key=$apiKey")
        .authentication().bearer(apiKey)
        .responseObject<RandomData>()

    return when (response.statusCode) {
        200 -> result.component1() // В случае успешного ответа возвращаем данные
        else -> null // В случае ошибки возвращаем null или обработайте ошибку по своему усмотрению
    }
}
//
//fun fetchRandomUserData(): Contact {
//    val client = OkHttpClient()
//    val request = Request.Builder()
//        .url("https://randomuser.me/api/")
//        .build()
//
//    client.newCall(request).execute().use { response ->
//        if (!response.isSuccessful) throw RuntimeException("Unexpected code $response")
//
//        val moshi = Moshi.Builder().build()
//        val adapter = moshi.adapter(RandomUserResponse::class.java)
//        val randomUser = adapter.fromJson(response.body!!.string())
//
//        val result = randomUser?.results?.firstOrNull()
//        val fullName = "${result?.name?.first} ${result?.name?.last}"
//        val phoneNumber = result?.phone ?: ""
//        val avatarUrl = result?.picture?.large ?: ""
//
//        return Contact(fullName, phoneNumber, avatarUrl)
//    }
//}
//
//data class RandomUserResponse(
//    @field:Json(name = "results") val results: List<RandomUserResult>
//)
//
//data class RandomUserResult(
//    @field:Json(name = "name") val name: RandomUserName,
//    @field:Json(name = "phone") val phone: String,
//    @field:Json(name = "picture") val picture: RandomUserPicture
//)
//
//data class RandomUserName(
//    @field:Json(name = "first") val first: String,
//    @field:Json(name = "last") val last: String
//)
//
//data class RandomUserPicture(
//    @field:Json(name = "large") val large: String
//)
//
