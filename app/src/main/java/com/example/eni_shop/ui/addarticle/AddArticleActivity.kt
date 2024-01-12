package com.example.eni_shop.ui.addarticle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.eni_shop.R
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityAddArticleBinding
import com.example.eni_shop.repository.ArticleRepository
import com.example.eni_shop.ui.HomeActivity
import com.google.android.material.snackbar.Snackbar

class AddArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_article)

        val article = Article()
        //val article = ArticleRepository.getArticle(1)
        binding.article = article

        binding.button.setOnClickListener {

            val id = ArticleRepository.addArticle(article)

            if(id != null){
                Intent(this, HomeActivity::class.java).also {
                    it.putExtra("title", article.titre)
                    it.putExtra("price", article.prix.toString())
                    startActivity(it)
                }
            }

//            Toast.makeText(this,
//                "Vous venez de créer ${article.titre} pour un montant de ${article.prix}",
//                Toast.LENGTH_LONG
//            ).show()
        }
    }
}