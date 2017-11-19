package com.toan_itc.baoonline.utils

import android.content.Context
import android.net.Uri
import android.support.annotation.AttrRes
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.FrameLayout
import com.toan_itc.baoonline.ui.player.PlayerExoHelper

/**
 * Created by toanit on 11/1/17.
 * Email:huynhvantoan.itc@gmail.com
 */

class CustomExoPlayerView(context: Context, attrs: AttributeSet?,
                          @AttrRes defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {
    private var trackSelector: DefaultTrackSelector? = null
    private var mTextureView: TextureView? = null
    /**
     * Returns the player currently set on this view, or null if no player is set.
     */
    var layout: AspectRatioFrameLayout? = null
        private set
    /**
     * Returns the player currently set on this view, or null if no player is set.
     */
    private var player: SimpleExoPlayer? = null
    private var componentListener: PlayerExoHelper? = null
    private var extractorsFactory: DefaultExtractorsFactory? = null
    private var mediaDataSourceFactory: DataSource.Factory? = null
    protected lateinit var videoSource: MediaSource

    @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : this(context, attrs, 0)

    init {
        val resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
        if (attrs != null) {
            LayoutInflater.from(context).inflate(R.layout.exo_simple_player_view, this)
            layout = findViewById(R.id.video_frame)
            layout!!.resizeMode = resizeMode
            mTextureView = TextureView(context)
            val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            mTextureView!!.layoutParams = params
            layout!!.addView(mTextureView, 0)
            val bandwidthMeter = DefaultBandwidthMeter()
            extractorsFactory = DefaultExtractorsFactory()
            val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
            trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)
            mediaDataSourceFactory = DefaultDataSourceFactory(context, Util.getUserAgent(context, context.getString(R.string.app_name)), bandwidthMeter as TransferListener<in DataSource>)
        }
    }

    fun initializePlayer(mContext: Context, playerExoHelper: PlayerExoHelper, linkMv: Uri) {
        try {
            if (player == null) {
                player = ExoPlayerFactory.newSimpleInstance(mContext, trackSelector!!)
                setPlayerListener(playerExoHelper)
                videoSource = ExtractorMediaSource(linkMv, mediaDataSourceFactory, extractorsFactory, null, null)
                player?.prepare(videoSource)
                setPlayWhenReady(false)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun setPlayerListener(playerExoHelper: PlayerExoHelper?) {
        if (player != null && playerExoHelper != null) {
            componentListener = playerExoHelper
            player?.setVideoTextureView(mTextureView)
            player?.addVideoListener(componentListener)
            player?.addListener(componentListener)
            player?.addTextOutput(componentListener)
            player?.volume = 0f
        }
    }

    fun releasePlayer() {
        try {
            if (player != null) {
                this.player?.addListener(null)
                this.player?.addVideoListener(null)
                this.player?.removeListener(componentListener)
                this.player?.setVideoTextureView(null)
                player?.release()
                player = null
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun destroyPlayer() {
        if (player != null) {
            player?.addTextOutput(null)
            player?.addVideoListener(null)
            player?.removeListener(componentListener)
            player?.setVideoSurface(null)
            player?.release()
            player = null
            mTextureView = null
            extractorsFactory = null
            trackSelector = null
            mediaDataSourceFactory = null
        }
    }

    fun setPlayWhenReady(shouldAutoPlay: Boolean) {
        if (player != null)
            player?.playWhenReady = shouldAutoPlay
    }

    fun stop() {
        try {
            if (player != null) {
                player?.stop()
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    fun replay() {
        if (player != null && player!!.currentPosition > 0) {
            player?.seekTo(0)
            // player.setPlayWhenReady(true);
        }
    }

    /**
     * Sets the resize mode which can be of value [AspectRatioFrameLayout.RESIZE_MODE_FIT],
     * [AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT] or
     * [AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH].
     *
     * @param resizeMode The resize mode.
     */
    fun setResizeMode(resizeMode: Int) {
        layout?.resizeMode = resizeMode
    }

}
