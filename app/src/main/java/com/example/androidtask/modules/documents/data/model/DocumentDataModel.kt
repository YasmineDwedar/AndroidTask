package com.example.androidtask.modules.documents.data.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DocumentDataModel(
    @Json(name = "title")
    val title: String?,
    @Json(name = "author_name")
    val authorName: List<String>?,
    @Json(name = "isbn")
    val isbnList: List<String>?
)