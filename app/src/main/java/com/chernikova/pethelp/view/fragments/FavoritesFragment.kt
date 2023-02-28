package com.chernikova.pethelp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.data.rv_adapters.AnimalsListRecyclerAdapter
import com.chernikova.pethelp.data.rv_adapters.TopSpacingItemDecoration
import com.chernikova.pethelp.databinding.FragmentFavoritesBinding


class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private var fragmentFavoritesBinding: FragmentFavoritesBinding? = null
    private lateinit var animalCardAdapter: AnimalsListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoritesBinding.bind(view)
        fragmentFavoritesBinding = binding


        //Получаем список при транзакции фрагмента
        val favoritesList: List<AnimalCard> = emptyList()

        binding.favoritesRecycler.apply {
            animalCardAdapter =
                AnimalsListRecyclerAdapter(object : AnimalsListRecyclerAdapter.OnItemClickListener {
                    override fun click(animalCard: AnimalCard) {
                        (requireActivity() as MainActivity).launchDetailsFragment(animalCard)
                    }
                })
            //Присваиваем адаптер
            adapter = animalCardAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        //Кладем нашу БД в RV
        animalCardAdapter.addItems(favoritesList)
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        fragmentFavoritesBinding = null
        super.onDestroyView()
    }
}