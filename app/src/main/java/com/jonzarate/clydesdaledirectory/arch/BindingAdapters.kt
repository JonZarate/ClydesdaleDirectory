package com.jonzarate.clydesdaledirectory.arch

import android.graphics.Color
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("avatarUrl")
fun loadAvatar(view: ImageView, avatarUrl: String?) {
    avatarUrl?.also {
        Glide.with(view.context)
            .load(it)
            .into(view)
    }
}

@BindingAdapter("color")
fun displayColor(view: ImageView, color: String?) {
    color?.also {
        view.setBackgroundColor(Color.parseColor(it))
    }
}
