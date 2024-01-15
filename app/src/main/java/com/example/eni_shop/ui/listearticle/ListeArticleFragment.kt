package com.example.eni_shop.ui.listearticle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.eni_shop.R
import com.example.eni_shop.databinding.FragmentListeArticleBinding
import com.example.eni_shop.repository.ArticleRepository


class ListeArticleFragment : Fragment() {
    val vm by viewModels<ListeArticleViewModel>()
    lateinit var binding: FragmentListeArticleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListeArticleBinding.inflate(inflater, container, false)
        //binding = DataBindingUtil.inflate(inflater, R.layout.fragment_liste_article, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articles =vm.getArticleList()

        if (articles != null) {

            for (a in articles) {
                val tv = TextView(context)
                tv.text = a.titre
                view.findViewById<LinearLayout>(R.id.linearLayoutListeArticle).addView(tv)
            }

            binding.buttonDetailArticle.setOnClickListener {
                val article = vm.getRandomArticle()

                article?.let { art ->
                    val direction = ListeArticleFragmentDirections.actionListeToDetail(
                        art
                    )
                    Navigation.findNavController(view).navigate(direction)
                }

            }
        }
    }


}