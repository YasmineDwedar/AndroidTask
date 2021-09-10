package com.example.androidtask.modules.documents.domain.repository

import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel

/**
 * Created by Yasmine on September,2021
 */
interface DocumentsRepo {
    suspend fun getDocumentsSearchResults(search: String, page: Int): List<DocumentDomainModel>
}