package com.example.androidtask.modules.documents.data.repository

import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.data.mapper.toDomainModel
import com.example.androidtask.modules.documents.data.retrofit.service.DocumentsAPI
import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel
import com.example.androidtask.modules.documents.domain.repository.DocumentsRepo
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
@DocumentsScope
class DocumentsRepoImpl @Inject constructor(private val documentsAPI: DocumentsAPI): DocumentsRepo {

    override suspend fun getDocumentsSearchResults(search: String, page: Int): List<DocumentDomainModel> {
        val listOfItems = documentsAPI.getDocumentsSearchResults(searchText = search, page = page).docs?.map {
            it.toDomainModel()
        } ?: emptyList()
        return listOfItems
        }

    override suspend fun getDocumentsFromTitle(title: String, page: Int): List<DocumentDomainModel> {
        val listOfItems = documentsAPI.getDocumentsFromTitle(title,page).docs?.map {
            it.toDomainModel()
        } ?: emptyList()
        return listOfItems
    }

    override suspend fun getDocumentsFromAuthor(author: String, page: Int): List<DocumentDomainModel> {
        val listOfItems = documentsAPI.getDocumentsFromAuthor(author,page).docs?.map {
            it.toDomainModel()
        } ?: emptyList()
        return listOfItems
    }
}

