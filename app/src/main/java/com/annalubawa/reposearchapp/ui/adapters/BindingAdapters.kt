package com.annalubawa.reposearchapp.ui.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("imageBinding")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}

@BindingAdapter("integerTextBinding")
fun loadInteger(view: TextView, number: Int) {
    view.text = "$number"
}

@BindingAdapter("starsNumTextBinding")
fun loadStarsNum(view: TextView, number: Int) {
    view.text = "Number of Stars ($number)"
}
