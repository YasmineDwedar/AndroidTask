package com.example.androidtask.ui.documents.presentation

import androidx.lifecycle.viewModelScope
import com.example.androidtask.base.BaseViewModel
import com.example.androidtask.modules.documents.data.repository.DocumentsRepository
import com.example.androidtask.ui.documents.presentation.model.BaseDocumentsModel
import com.example.androidtask.ui.documents.presentation.model.DocumentPresentationModel
import com.example.androidtask.ui.documents.presentation.model.DocumentsShimmerModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Yasmine on September,2021
 */
class DocumentsFragmentViewModel @Inject constructor(private val repository: DocumentsRepository) : BaseViewModel() {

    private var _documentsStateFlow = MutableStateFlow<List<BaseDocumentsModel>>(emptyList())
    val documentsStateFlow: StateFlow<List<BaseDocumentsModel>>
        get() = _documentsStateFlow
    init {
        viewModelScope.launch {
            _documentsStateFlow.emit(getShimmerList())
        }
    }

    fun getDocumentsSearchResults(search: String, page: Int) {
        viewModelScope.launch {
            _documentsStateFlow.emit(repository.getDocumentsSearchResults(search = search, page = page))

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
            DocumentsShimmerModel(),)
    }

}