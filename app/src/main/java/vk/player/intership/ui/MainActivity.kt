package vk.player.intership.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vk.player.intership.R

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private var flag: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE
//                        , Manifest.permission.WRITE_EXTERNAL_STORAGE), EXTERNAL_STORAGE_PERMISSION_CODE)
//            }

//        setupPermissions()
//
//        r1.visibility = View.VISIBLE
//        newFolderBtn.setOnClickListener {
//
//
//            val permission = ContextCompat.checkSelfPermission(this,
//                    Manifest.permission.READ_EXTERNAL_STORAGE)
//
//            if (permission != PackageManager.PERMISSION_GRANTED) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////                    Toast.makeText(this, "work", Toast.LENGTH_SHORT).show()
//                    requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE
//                            , Manifest.permission.WRITE_EXTERNAL_STORAGE), EXTERNAL_STORAGE_PERMISSION_CODE)
//                    }
//                }else{
//
                replaceCurrentFragment(FolderFragment())
//
//
//            }
////                setupPermissions()
////                if (flag != true){
////                    Toast.makeText(this, "work", Toast.LENGTH_SHORT).show()
////                    replaceCurrentFragment(DirectoriesFragment())
////                }
//
////            }else{
////                replaceCurrentFragment(DirectoriesFragment())
////            }
////            replaceCurrentFragment(DirectoriesFragment())
//
//
////            r1.visibility = View.INVISIBLE
////            replaceCurrentFragment(DirectoriesFragment())
//        }






    }



    private fun replaceCurrentFragment(fragment: androidx.fragment.app.Fragment, bundle: Bundle = Bundle()
                                       , addToBackStack: Boolean = false) {
        fragment.arguments = bundle
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .apply { if (addToBackStack) addToBackStack(null) }
                .commit()
    }


//    private fun setupPermissions() {
//        val permission = ContextCompat.checkSelfPermission(this,
//                Manifest.permission.READ_EXTERNAL_STORAGE)
//
//        if (permission != PackageManager.PERMISSION_GRANTED) {
//           flag = true
//        }
//    }
//
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        when (requestCode) {
//            EXTERNAL_STORAGE_PERMISSION_CODE -> {
//                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//
//                    replaceCurrentFragment(DirectoriesFragment())
//                }
//                return
//            }
//            else -> {
//
//            }
//        }
//    }

}
