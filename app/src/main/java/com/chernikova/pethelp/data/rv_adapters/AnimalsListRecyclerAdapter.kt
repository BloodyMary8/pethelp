package com.chernikova.pethelp.data.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.databinding.AnimalItemBinding
import com.chernikova.pethelp.rv_viewholders.AnimalsViewHolder

class AnimalsListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {

    //Здеь у нас хранится список элементов для RV
    val items = mutableListOf<AnimalCard>()

    //Этот метод нужно переопределить на возврат количества елементов в списке RV
    override fun getItemCount() = items.size

    //В этом методе мы привязываем наш view holder и передаем туда "надутую" верстку нашего фильма
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val animalItemBinding = AnimalItemBinding.inflate(layoutInflater, parent, false)
        return AnimalsViewHolder(animalItemBinding)
    }

    //В этом методе будет привзяка полей из объекта Film, к view из film_item.xml
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        //Проверяем какой у нас ViewHolder
        when (holder) {
            is AnimalsViewHolder -> {
                //Вызываем метод bind(), который мы создали и передаем туда объект
                //из нашей базы данных с указанием позиции
                holder.bind(items[position])
                //Обрабатываем нажатие на весь элемент целиком(можно сделать на отдельный элемент
                //напрмер, картинку) и вызываем метод нашего листенера, который мы получаем из
                //конструктора адаптера
                holder.animalItemBinding.itemContainer.setOnClickListener { clickListener.click(items[position]) }
            }
        }
    }

    //Метод для добавления объектов в наш список
    fun addItems(list: List<AnimalCard>) {
        //Сначала очишаем(если не реализовать DiffUtils)
        items.clear()
        //Добавляем
        items.addAll(list)
        //Уведомляем RV, что пришел новый список и ему нужно заново все "привязывать"
        notifyDataSetChanged()
    }

    //Интерфейс для обработки кликов
    interface OnItemClickListener {
        fun click(animalCard: AnimalCard)
    }
}