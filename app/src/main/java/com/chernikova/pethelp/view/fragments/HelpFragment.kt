package com.chernikova.pethelp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chernikova.pethelp.R
import com.chernikova.pethelp.databinding.FragmentHelpBinding
import com.chernikova.pethelp.view_model.HelpFragmentViewModel



class HelpFragment : Fragment() {

        private var fragmentHelpBinding: FragmentHelpBinding? = null

        private val viewModel by lazy {
            ViewModelProvider.NewInstanceFactory().create(HelpFragmentViewModel::class.java)
        }
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_help, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val binding = FragmentHelpBinding.bind(view)
            fragmentHelpBinding = binding
            //Слушаем, какой у нас сейчас выбран вариант в настройках
            viewModel.categoryPropertyLifeData.observe(viewLifecycleOwner, Observer<String> {
                when(it) {
                    DOG_CATEGORY -> binding.radioGroup.check(R.id.radio_dog)
                    CAT_CATEGORY -> binding.radioGroup.check(R.id.radio_cat)
                    ANOTHER_CATEGORY -> binding.radioGroup.check(R.id.radio_another)
                    SHELTER_CATEGORY -> binding.radioGroup.check(R.id.radio_shelter)
                }
            })
            //Слушатель для отправки нового состояния в настройки
            binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                when(checkedId) {
                    R.id.radio_dog -> viewModel.putCategoryProperty(DOG_CATEGORY)
                    R.id.radio_cat -> viewModel.putCategoryProperty(CAT_CATEGORY)
                    R.id.radio_another -> viewModel.putCategoryProperty(ANOTHER_CATEGORY)
                    R.id.radio_shelter -> viewModel.putCategoryProperty(SHELTER_CATEGORY)
                }
            }
        }

        companion object {
            private const val DOG_CATEGORY = "dog"
            private const val CAT_CATEGORY = "cat"
            private const val ANOTHER_CATEGORY = "another"
            private const val SHELTER_CATEGORY = "shelter"
        }
    }