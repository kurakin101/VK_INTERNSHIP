package vk.player.intership.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import vk.player.intership.model.Track
import java.util.*

@Parcelize
class Playlist(val list: ArrayList<Track>) : Parcelable {
    constructor(index: Int, playlist: ArrayList<Track>) : this(playlist) {
        Collections.rotate(playlist, -index)
    }
}