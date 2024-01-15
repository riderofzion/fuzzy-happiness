package com.example.eni_shop.ui.addarticle

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.eni_shop.R
import com.example.eni_shop.databinding.ActivityAddArticleBinding
import com.example.eni_shop.ui.HomeActivity

class AddArticleActivity : AppCompatActivity() {
    val vm by viewModels<AddArticleViewModel>()
    lateinit var binding: ActivityAddArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_article)

        //val article = ArticleRepository.getArticle(1)
        binding.vm = vm

        binding.button.setOnClickListener {

            val id = vm.addArticle()/*ArticleRepository.addArticle(article)*/

            if(id != null){
                Intent(this, HomeActivity::class.java).also {
                    it.putExtra("title", vm.article.value?.titre)
                    it.putExtra("price", vm.article.value?.prix.toString())
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