package com.example.androidtask.modules.documents.data.remote

import com.example.androidtask.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.data.mapper.toPresentationModel
import com.example.androidtask.modules.documents.data.model.response.Document
import com.example.androidtask.modules.documents.data.model.response.DocumentResponse
import com.example.androidtask.modules.documents.data.service.DocumentsAPI
import com.example.androidtask.ui.documents.presentation.model.DocumentPresentationModel
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
@DocumentsScope
class DocumentsRepoRemoteImpl @Inject constructor(private val documentsAPI: DocumentsAPI) {

    suspend fun getDocumentsSearchResults(search: String, page: Int): List<DocumentPresentationModel> {
        val listOfItems = documentsAPI.getDocumentsSearchResults(searchText = search, page = page).docs?.map {
            it.toPresentationModel()
        } ?: emptyList()
        return listOfItems
        }

}

