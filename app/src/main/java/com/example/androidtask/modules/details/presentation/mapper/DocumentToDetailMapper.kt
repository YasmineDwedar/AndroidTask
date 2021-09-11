package com.example.androidtask.modules.details.presentation.mapper

import com.example.androidtask.modules.details.presentation.model.BaseDetailsModel
import com.example.androidtask.modules.details.presentation.model.ISBNListModel
import com.example.androidtask.modules.details.presentation.model.IsbnModel
import com.example.androidtask.modules.details.presentation.model.TitleAuthorModel
import com.example.androidtask.modules.documents.domain.mapper.toPresentationModel
import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel

/**
 * Created by Yasmine on September,2021
 */

fun DocumentPresentationModel.toBaseDetailsModel(): List<BaseDetailsModel> {
    val list = ArrayList<BaseDetailsModel>()
    list.add(TitleAuthorModel(title, author))
    list.add(ISBNListModel(
            isbnList?.map {
                IsbnModel(it, "https://covers.openlibrary.org/b/isbn/$it-L.jpg?default=false")
            }?.take(5)
        )
    )
    return list
}