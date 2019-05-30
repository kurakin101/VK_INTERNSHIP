package vk.player.intership.ui


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_folder.view.*
import vk.player.intership.EXTERNAL_STORAGE_PERMISSION_CODE
import vk.player.intership.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FolderFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_folder, container, false)
        
        v.newFolderBtn.setOnClickListener {


            val permission = ContextCompat.checkSelfPermission(requireActivity(),
                    Manifest.permission.READ_EXTERNAL_STORAGE)

            if (permission != PackageManager.PERMISSION_GRANTED) { 
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE
                            , Manifest.permission.WRITE_EXTERNAL_STORAGE), EXTERNAL_STORAGE_PERMISSION_CODE)
                }
            }else{
                replaceCurrentFragment(DirectoriesFragment())
            }

        }
        
        return v
    }


    private fun replaceCurrentFragment(fragment: androidx.fragment.app.Fragment, bundle: Bundle = Bundle()
                                       , addToBackStack: Boolean = false) {
        
        this.requireFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment, null)
                .addToBackStack(null)
                .commit()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            EXTERNAL_STORAGE_PERMISSION_CODE -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                    replaceCurrentFragment(DirectoriesFragment())
                }
                return
            }
            else -> {

            }
        }
    }
    
}
