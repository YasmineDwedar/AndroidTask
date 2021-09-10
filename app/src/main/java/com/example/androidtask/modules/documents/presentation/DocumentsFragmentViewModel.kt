package com.example.androidtask.modules.documents.presentation

import com.example.androidtask.commons.presentation.BaseViewModel
import com.example.androidtask.modules.documents.domain.mapper.toPresentationModel
import com.example.androidtask.modules.documents.domain.usecase.SearchDocumentsUseCases
import com.example.androidtask.modules.documents.presentation.model.BaseDocumentsModel
import com.example.androidtask.modules.documents.presentation.model.DocumentsShimmerModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
class DocumentsFragmentViewModel @Inject constructor(private val searchDocumentsUseCases: SearchDocumentsUseCases) :
    BaseViewModel() {

    private var _documentsStateFlow = MutableStateFlow<List<BaseDocumentsModel>>(emptyList())
    val documentsStateFlow: StateFlow<List<BaseDocumentsModel>>
        get() = _documentsStateFlow


    fun getDocumentsSearchResults(search: String, page: Int) {
        launchSafeCoroutine {
            _documentsStateFlow.emit(getShimmerList())
            _documentsStateFlow.emit(searchDocumentsUseCases.execute(search = search, page = page).map {
                it.toPresentationModel()
            })

        }
    }
}

private fun getShimmerList(): List<DocumentsShimmerModel> {
    return listOf(
        DocumentsShimmerModel(),
        DocumentsShimmerModel(),
        DocumentsShimmerModel(),
        DocumentsShimmerModel(),
        DocumentsShimmerModel(),
        DocumentsShimmerModel(),
        DocumentsShimmerModel(),
        DocumentsShimmerModel(),
    )
}

