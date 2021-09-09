package com.example.androidtask.modules.documents.data.mapper

import com.example.androidtask.modules.documents.data.model.response.Document
import com.example.androidtask.ui.documents.presentation.model.DocumentPresentationModel

/**
 * Created by Yasmine on September,2021
 */


fun Document.toPresentationModel(): DocumentPresentationModel {
    return DocumentPresentationModel(
            title = this.title ?: "",
            author = this.authorName?.get(0) ?: "" ,
    )
}