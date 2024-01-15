package com.example.eni_shop.ui.listearticle

import androidx.lifecycle.ViewModel
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository

class ListeArticleViewModel : ViewModel() {
    fun getArticleList() : List<Article>? = ArticleRepository.getAllArticle()
    fun getRandomArticle() : Article? = ArticleRepository.getAllArticle()?.random()
}