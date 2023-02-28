package com.chernikova.pethelp.rv_viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.databinding.AnimalItemBinding


class AnimalsViewHolder(val animalItemBinding: AnimalItemBinding) : RecyclerView.ViewHolder(animalItemBinding.root) {

        private val title = animalItemBinding.title
        private val poster = animalItemBinding.poster
        private val description = animalItemBinding.description

        fun bind(animalCard: AnimalCard) {
           // Устанавливаем заголовок
            title.text = animalCard.title
            //Устанавливаем постер
            //Указываем контейнер, в которм будет "жить" наша картинка
            Glide.with(itemView)
                //Загружаем сам ресурс
              .load(animalCard.poster)
            //Центруем изображение
                .centerCrop()
               // Указываем ImageView, куда будем загружать изображение
               .into(poster)
            //Устанавливаем описание
           description.text = animalCard.description
        }
    }
