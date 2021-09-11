package com.example.androidtask.modules.documents.domain.usecase

import com.example.androidtask.commons.di.scopes.DocumentsScope
import com.example.androidtask.modules.documents.domain.model.DocumentDomainModel
import com.example.androidtask.modules.documents.domain.repository.DocumentsRepo
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
@DocumentsScope
class SearchByTitleUseCase @Inject constructor(private val documentsRepo: DocumentsRepo) {
    suspend fun execute(title: String): List<DocumentDomainModel>{
        return documentsRepo.getDocumentsFromTitle(title)
    }
}