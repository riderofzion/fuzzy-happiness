package com.example.eni_shop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityMainBinding
import com.example.eni_shop.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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