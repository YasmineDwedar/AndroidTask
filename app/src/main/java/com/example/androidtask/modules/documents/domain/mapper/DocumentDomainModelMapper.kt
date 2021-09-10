package com.example.androidtask.modules.documents.domain.mapper

import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel

/**
 * Created by Yasmine on September,2021
 */
fun DocumentDomainModel.toPresentationModel(): DocumentPresentationModel {
    return DocumentPresentationModel(
        title = this.title ,
        author = this.author,
    )
}