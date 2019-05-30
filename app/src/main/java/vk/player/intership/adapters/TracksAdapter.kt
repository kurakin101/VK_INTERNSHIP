package vk.player.intership.adapters

import androidx.recyclerview.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import vk.player.intership.R
import vk.player.intership.model.Track

open class TracksAdapter(private val clickListener: (Int) -> Unit
                         , private val longClickListener: (Int) -> Boolean = { true }) : Adapter<TracksAdapter.TrackViewHolder>() {

    val items = arrayListOf<Track>()


    fun addTrack(track: Track) {
        items.add(track)
        this.notifyItemInserted(itemCount - 1)
    }

    fun addTrackList(trackList: ArrayList<Track>) {
        items.clear()
        items.addAll(trackList)
        this.notifyItemRangeInserted(0, items.size)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) =
            holder.bindTrack(items[position], clickListener, longClickListener)

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.track_layout, parent, false)
        return TrackViewHolder(itemView)
    }

    class TrackViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        fun bindTrack(track: Track, clickListener: (Int) -> Unit, longClickListener: (Int) -> Boolean) {
            with(itemView) {
//                trackTitle.text = track.title
//                trackArtist.text = track.artist


               setOnClickListener { clickListener(this@TrackViewHolder.adapterPosition) }
                setOnLongClickListener { longClickListener(this@TrackViewHolder.adapterPosition) }
            }
        }
    }

}