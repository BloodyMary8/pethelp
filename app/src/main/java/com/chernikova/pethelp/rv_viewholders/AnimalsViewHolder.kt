package com.chernikova.pethelp.rv_viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.databinding.AnimalItemBinding


class AnimalsViewHolder(val animalItemBinding: AnimalItemBinding) : RecyclerView.ViewHolder(animalItemBinding.root) {

        private val title = animalItemBinding.title
        private val poster = animalItemBinding.poster
        private val description = animalItemBinding.description

        fun bind(animalCard: AnimalCard) {
            //Устанавливаем заголовок
            title.text = animalCard.name
            //Устанавливаем постер
            //Указываем контейнер, в которм будет "жить" наша картинка
            Glide.with(itemView)
                //Загружаем сам ресурс
              .load(com.chernikova.remote_module.entity.ApiConstants.IMAGES_URL + "w342" + animalCard.photos)
            //Центруем изображение
                .centerCrop()
               // Указываем ImageView, куда будем загружать изображение
               .into(poster)
            //Устанавливаем описание
            description.text = animalCard.description
        }
    }
