package br.com.rstudio.myapplication.core.di

import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.core.GlideImageLoader
import br.com.rstudio.myapplication.core.ImageLoader
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object AppModule {

    val module = module {

        single {
            Glide.with(androidContext())
                .setDefaultRequestOptions(
                    RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .error(R.drawable.ic_launcher_foreground)
                        .centerCrop()
                )
        }

        single<ImageLoader> { GlideImageLoader(glide = get()) }
    }
}