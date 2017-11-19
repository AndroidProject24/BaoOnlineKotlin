package com.toan_itc.baoonline.callback.player

import android.support.annotation.MainThread
import android.support.annotation.UiThread
import android.support.annotation.WorkerThread
import com.toan_itc.baoonline.utils.CustomExoPlayerView

/**
 * Created by Toan.IT on 11/2/17.
 * Email:Huynhvantoan.itc@gmail.com
 */
interface PlayerCallback {
    @UiThread
    fun showSnackBar(title: String)
    @MainThread
    fun releaseExoPlayer()

    fun getExoPlayer(): CustomExoPlayerView

    fun isPlaySuperPowered(): Int
    @WorkerThread
    fun isLyric(): Boolean

    fun nextSong(userID: String)

    fun lastSong()

    fun exoPlayerReady(isPlay: Int)

    fun exoPlayerStart(exoReady: Boolean)

    fun prepareExoPlayer(playWhenReady: Boolean,isStream: Int)

    fun refreshNextSong(songNext: String, avatar: String, key: Int)

    fun setOverlayBgHeight(heightInPercent: Float)

    fun resetConnection()

    fun removeSong(idSong: Int)

    fun onCommandSearch()

    fun impressSearch(ID: Int, singer_name: String)

    fun onCommandReplay(isRecorder: Boolean)

    fun onScoreFragmentCallback(noNewSong: Boolean)

    fun showPromotion()

    fun showLogo()

    fun playSongYou(isPlay: Boolean)

    fun showConnect(type: String)
}