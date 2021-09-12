package com.example.androidtask.modules.documents.domain.repository

import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel
import com.example.androidtask.modules.documents.presentation.model.DocumentPresentationModel

/**
 * Created by Yasmine on September,2021
 */
interface DocumentsRepo {
    suspend fun getDocumentsSearchResults(search: String, page: Int): List<DocumentDomainModel>
    suspend fun getDocumentsFromTitle(title: String, page: Int): List<DocumentDomainModel>
    suspend fun getDocumentsFromAuthor(author: String, page: Int): List<DocumentDomainModel>
}