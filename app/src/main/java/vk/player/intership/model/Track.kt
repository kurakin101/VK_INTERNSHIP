package vk.player.intership.model

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Track(val title: String, val artist: String,
                 val contentUri: Uri, val thumbnail: Uri = Uri.EMPTY) : Parcelable