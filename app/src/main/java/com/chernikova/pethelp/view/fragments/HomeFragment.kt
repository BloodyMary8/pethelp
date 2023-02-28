package com.chernikova.pethelp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chernikova.pethelp.MainActivity
import com.chernikova.pethelp.data.entity.AnimalCard
import com.chernikova.pethelp.data.rv_adapters.AnimalsListRecyclerAdapter
import com.chernikova.pethelp.data.rv_adapters.TopSpacingItemDecoration
import com.chernikova.pethelp.databinding.FragmentHomeBinding
import com.chernikova.pethelp.domain.Interactor
import com.chernikova.pethelp.view_model.HomeFragmentViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*


class HomeFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(HomeFragmentViewModel::class.java)
    }

    //private val autoDisposable = AutoDisposable()

    private lateinit var animalsAdapter: AnimalsListRecyclerAdapter
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPullToRefresh()
        //находим наш RV
        initRecycler()
        //Кладем нашу БД в RV
       // AnimationHelper.performFragmentCircularRevealAnimation(binding.homeFragmentRoot, requireActivity(),1)

        viewModel.animalsListData
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onNext={ list ->
                animalsAdapter.addItems(list)
            },
                onError={ Toast.makeText(requireContext(), "Что-то пошло не так", Toast.LENGTH_SHORT).show()
                }
            )
           // .addTo(autoDisposable)
        viewModel.showProgressBar
            .subscribeOn(Schedulers.single())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy (onNext={
                binding.progressBar.isVisible = it
            },
                onError ={ Toast.makeText(requireContext(), "Что-то пошло не так", Toast.LENGTH_SHORT).show()
                })
          //  .addTo(autoDisposable)
    }


    private fun initPullToRefresh() {
        //Вешаем слушатель, чтобы вызвался pull to refresh
        binding.pullToRefresh.setOnRefreshListener {
            //Чистим адаптер(items нужно будет сделать паблик или создать для этого публичный метод)
            animalsAdapter.items.clear()
            //Делаем новый запрос фильмов на сервер
            viewModel.getAnimals()
            //Убираем крутящиеся колечко
            binding.pullToRefresh.isRefreshing = false
        }
    }


    private fun initRecycler() {
        binding.mainRecycler.apply {
            animalsAdapter =
                AnimalsListRecyclerAdapter(object : AnimalsListRecyclerAdapter.OnItemClickListener {
                    override fun click(animalCard: AnimalCard) {
                        (requireActivity() as MainActivity)
                    }
                })
            //Присваиваем адаптер
            adapter = animalsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}