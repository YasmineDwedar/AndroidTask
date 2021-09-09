package com.example.androidtask.modules.documents.data.repository

import com.example.androidtask.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.data.mapper.toPresentationModel
import com.example.androidtask.modules.documents.data.remote.DocumentsRepoRemoteImpl
import com.example.androidtask.ui.documents.presentation.model.DocumentPresentationModel
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
@DocumentsScope
class DocumentsRepository @Inject constructor(private val documentsRepoRemoteImpl: DocumentsRepoRemoteImpl) {
    suspend fun getDocumentsSearchResults(search: String, page: Int) =
            documentsRepoRemoteImpl.getDocumentsSearchResults(search = search, page = page)

}

