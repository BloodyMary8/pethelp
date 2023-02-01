package com.chernikova.pethelp



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chernikova.pethelp.databinding.ActivityMainBinding
import com.chernikova.pethelp.view.fragments.HomeFragment
import androidx.fragment.app.Fragment
import com.chernikova.pethelp.view.fragments.HelpFragment



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //receiver = ConnectionChecker()

        //val filters = IntentFilter().apply {
         //   addAction(Intent.ACTION_POWER_CONNECTED)
        ///    addAction(Intent.ACTION_BATTERY_LOW)
       // }
        //registerReceiver(receiver, filters)

        initNavigation()

        //Зупускаем фрагмент при старте
       // supportFragmentManager
        //    .beginTransaction()
         //   .add(R.id.fragment_placeholder, HelpFragment())
        //    .addToBackStack(null)
        //    .commit()
    }

    //fun launchDetailsFragment(animalCard: AnimalCard) {
        //Создаем "посылку"
     //   val bundle = Bundle()
        //Кладем наш фильм в "посылку"
    //    bundle.putParcelable("animalCard", animalCard)
        //Кладем фрагмент с деталями в перменную
     //   val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
      //  fragment.arguments = bundle


    private fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.favorites -> {
                    val tag = "favorites"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: FavoritesFragment(), tag)
                    true
                }
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: HomeFragment(), tag)
                    true
                }
                R.id.help -> {
                    val tag = "help"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: HelpFragment(), tag)
                    true
                }
                else -> false
            }
        }
    }
    private fun checkFragmentExistence(tag: String): Fragment? = supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

}





