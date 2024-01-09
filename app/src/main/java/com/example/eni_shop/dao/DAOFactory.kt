package com.example.eni_shop.dao

import com.example.eni_shop.dao.memory.ArticleDAOMemoryImpl
import com.example.eni_shop.dao.network.ArticleDAONetworkImpl

class DAOFactory {
    companion object {

        fun createArticleDAO(type: DaoType): ArticleDAO? {
            val dao: ArticleDAO?

            when (type) {
                DaoType.MEMORY -> dao = ArticleDAOMemoryImpl()
                DaoType.NETWORK -> dao = ArticleDAONetworkImpl()
                else -> dao = null
            }

            return dao
        }
    }
}