package com.example.eni_shop.dao.memory

import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import java.util.Date

class ArticleDAOMemoryImpl : ArticleDAO {

    //permet de gérer le static
    companion object {
        private val articlesInMemory: MutableList<Article> = mutableListOf(
            Article(
                1,
                "Souris",
                "Souris sans fil",
                10.0, "",
                Date()
            ),
            Article(2, "Ecran", "Ecran sans fil", 1000.0, "", Date()),
            Article(3, "Clavier", "Clavier sans fil", 25.0, "", Date()),
        )
    }


    override fun selectById(id: Long): Article? {
        return articlesInMemory.find { it.id == id }
    }

    override fun addNewOne(article: Article): Long {
        articlesInMemory.add(article)
        article.id = articlesInMemory.size.toLong()
        return article.id
    }

    override fun selectAll(): List<Article> {
        return articlesInMemory
    }



}