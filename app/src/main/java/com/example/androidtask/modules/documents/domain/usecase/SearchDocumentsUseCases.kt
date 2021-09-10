package com.example.androidtask.modules.documents.domain.usecase

import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel
import com.example.androidtask.modules.documents.domain.repository.DocumentsRepo
import javax.inject.Inject

/**
 * Created by Yasmine on July,2021
 */
@DocumentsScope
class SearchDocumentsUseCases @Inject constructor(private val documentsRepo: DocumentsRepo) {
    suspend fun execute(search: String, page: Int): List<DocumentDomainModel>{
     return documentsRepo.getDocumentsSearchResults(search, page)
    }
}