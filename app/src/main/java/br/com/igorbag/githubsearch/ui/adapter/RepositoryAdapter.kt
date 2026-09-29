package br.com.igorbag.githubsearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.igorbag.githubsearch.R
import br.com.igorbag.githubsearch.domain.Repository

class RepositoryAdapter(private val repositories: List<Repository>) :
    RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    var repoItemListener: (Repository) -> Unit = {}
    var btnShareListener: (Repository) -> Unit = {}

    // Cria uma nova view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    // Pega o conteudo da view e troca pela informacao de item de uma lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO 8 - bind do ViewHolder: mostra o nome e configura os cliques
        val repository = repositories[position]
        holder.repoName.text = repository.name

        // clique no item (abrir no navegador)
        holder.itemView.setOnClickListener {
            repoItemListener(repository)
        }

        // clique no botao de compartilhar
        holder.share.setOnClickListener {
            btnShareListener(repository)
        }
    }

    // Pega a quantidade de repositorios da lista
    // TODO 9 - conta os itens da lista
    override fun getItemCount(): Int = repositories.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // TODO 10 - ViewHolder com as views do item do repositorio
        val repoName: TextView
        val share: ImageView

        init {
            view.apply {
                repoName = findViewById(R.id.tv_repo_name)
                share = findViewById(R.id.iv_share)
            }
        }
    }
}
