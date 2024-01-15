package com.example.eni_shop.ui.addarticle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository

class AddArticleViewModel : ViewModel() {
    val article = MutableLiveData(Article());
    fun addArticle(){
        article.value?.let {
            ArticleRepository.addArticle(it)
        }

    }
}