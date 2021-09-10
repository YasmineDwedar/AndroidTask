package com.example.androidtask.modules.documents.data.retrofit.response


import com.example.androidtask.modules.documents.data.model.DocumentDataModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DocumentResponse(
    @Json(name = "docs")
    val docs: List<DocumentDataModel>?,
    @Json(name = "numFound")
    val numFound: Int?,
    @Json(name = "num_found")
    val numberFound: Int?,
    @Json(name = "numFoundExact")
    val numFoundExact: Boolean?,
    @Json(name = "offset")
    val offset: Any?,
    @Json(name = "q")
    val q: String?,
    @Json(name = "start")
    val start: Int?
)