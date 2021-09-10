package com.example.androidtask.modules.documents.data.mapper

import com.example.androidtask.modules.documents.data.model.DocumentDataModel
import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel

/**
 * Created by Yasmine on September,2021
 */


fun DocumentDataModel.toDomainModel(): DocumentDomainModel {
    return DocumentDomainModel(
            title = this.title ?: "",
            author = this.authorName?.getOrNull(0) ?: "Not Determined" ,
    )
}