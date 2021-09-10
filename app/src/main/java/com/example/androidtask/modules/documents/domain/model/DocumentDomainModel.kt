package com.example.androidtask.modules.documents.domain.model

/**
 * Created by Yasmine on September,2021
 */
class DocumentDomainModel(
    val title: String="",
    val author: String="",
    val isbnList: List<String>?= emptyList()
)