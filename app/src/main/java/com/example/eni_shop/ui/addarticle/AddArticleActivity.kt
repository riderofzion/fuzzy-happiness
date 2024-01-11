package com.example.eni_shop.ui.addarticle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.eni_shop.R
import com.example.eni_shop.databinding.ActivityAddArticleBinding
import com.example.eni_shop.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

class AddArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_article)

        //val article = Article()
        val article = ArticleRepository.getArticle(1)
        binding.article = article

        binding.button.setOnClickListener {
            Snackbar.make(
                it,
                "Vous venez de créer ${article?.titre} pour un montant de ${article?.prix}",
                Snackbar.LENGTH_LONG
            ).show()

//            Toast.makeText(this,
//                "Vous venez de créer ${article.titre} pour un montant de ${article.prix}",
//                Toast.LENGTH_LONG
//            ).show()
        }
    }
}