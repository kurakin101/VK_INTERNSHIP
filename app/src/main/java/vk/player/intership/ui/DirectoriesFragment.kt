package vk.player.intership.ui

import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import vk.player.intership.adapters.DirectoriesAdapter
import vk.player.intership.R
import vk.player.intership.getParent

class DirectoriesFragment : androidx.fragment.app.Fragment() {

    private val directoryList = hashSetOf<String>()
    private val adapter = DirectoriesAdapter { openDirectory(it) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadDirectoryList()
        setupRecyclerView()
        adapter.addDirectories(ArrayList(directoryList.toList()))
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

    }


    private fun loadDirectoryList() {
        val contentResolver = context!!.contentResolver
        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val cursor = contentResolver.query(uri, null, null, null, null)
        cursor.run {
            if (moveToFirst()) {
                val path = getColumnIndex(MediaStore.Audio.Media.DATA)
                val isMusic = getColumnIndex(MediaStore.Audio.Media.IS_MUSIC)
                do {
                    val thisIsMusic = getInt(isMusic)
                    if (thisIsMusic != 0) {
                        val thisPath = getString(path)
                        directoryList.add(getParent(thisPath))
                    }
                } while (moveToNext())
            }
        }
        cursor.close()
    }

    private fun openDirectory(path: String) {
        val bundle = Bundle().apply { putString("currentDirectory", path) }
        val fragment = LocalTracksFragment().apply { arguments = bundle }
        this.requireFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment, null)
                .addToBackStack(null)
                .commit()
    }
}