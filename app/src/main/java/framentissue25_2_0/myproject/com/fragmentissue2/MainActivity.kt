package framentissue25_2_0.myproject.com.fragmentissue2


import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container, FragmentOne()).commit()
    }

    fun openFragmentThree() {
        supportFragmentManager.beginTransaction().replace(R.id.container, FragmentTwo()).addToBackStack("").commit()
    }

    fun openFragmentFour() {
        supportFragmentManager.beginTransaction()
                // Uncomment below to fix the issue in 25.2.0
                // .setAllowOptimization(true)
                .replace(R.id.container, FragmentThree()).addToBackStack("").commit()
    }

    fun resetOriginal() {
        val homeFragmentId = supportFragmentManager.getBackStackEntryAt(0).id
        supportFragmentManager.popBackStackImmediate(homeFragmentId, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

}
