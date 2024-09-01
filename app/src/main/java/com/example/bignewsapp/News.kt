package com.example.bignewsapp

import com.google.gson.annotations.SerializedName

data class News(val articles:ArrayList<Article>)

data class Article(val title:String,
                   val url:String,
                   @SerializedName("urlToImage")
                   val image:String,
                   val source:Source)
data class Source(val name:String)