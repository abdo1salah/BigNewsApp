package com.example.bignewsapp



import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.bignewsapp.databinding.ListItemBinding


class NewsAdapter(val a :Activity, val articles: ArrayList<Article>):Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(val binding : ListItemBinding): ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val b = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(b)
    }

    override fun getItemCount() = articles.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.binding.titleTv.text = articles[position].title
        holder.binding.sourceTv.text = articles[position].source.name

        Glide
            .with(holder.binding.articleImage.context)
            .load(articles[position].image)
            .error(R.drawable.broken_image)
            .transition(DrawableTransitionOptions.withCrossFade(1000))
            .into(holder.binding.articleImage)
        val url = articles[position].url
        holder.binding.articleContainer.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW,url.toUri())
            a.startActivity(i)
        }
        holder.binding.shareFab.setOnClickListener {
            ShareCompat
                .IntentBuilder(a)
                .setType("text/plain")
                .setChooserTitle("Share article with: ")
                .setText(url)
                .startChooser()

        }

    }
}
