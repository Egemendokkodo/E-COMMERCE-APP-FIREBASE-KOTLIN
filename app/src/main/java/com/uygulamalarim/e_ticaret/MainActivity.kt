package com.uygulamalarim.e_ticaret

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*val userId = intent.getStringExtra("user_id")
    val emailId = intent.getStringExtra("email_id")
    val name = intent.getStringExtra("name")
    val surname = intent.getStringExtra("surname")*/

    protected lateinit var videov: VideoView
    protected lateinit var nMediaPlayer: MediaPlayer
    protected var mCurrentVideoPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)




        videov = findViewById(R.id.videoView)
        landingPageVideo()

        loginBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(this, LoginPage::class.java)
            startActivity(i)
        })
        textButton.setOnClickListener(View.OnClickListener {
            val i = Intent(this, RegisterPage::class.java)
            startActivity(i)
            this.finish()
        })
        continueWithout.setOnClickListener(View.OnClickListener {
            val i = Intent(this, AppPage::class.java)
            startActivity(i)
            this.finish()
        })


    }

    private fun landingPageVideo() {
        //val path="android.resource://com.uygulamalarim.e_ticaret/"+R.raw.back_video
        val uri = Uri.parse("android.resource://com.uygulamalarim.e_ticaret/" + R.raw.back_video)
        videov.setVideoURI(uri)
        videov.start()
        videov.setOnPreparedListener { mp ->
            nMediaPlayer = mp
            nMediaPlayer.isLooping = true
            if (mCurrentVideoPosition != 0) {
                nMediaPlayer.seekTo(mCurrentVideoPosition)
                nMediaPlayer.start()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mCurrentVideoPosition = nMediaPlayer.currentPosition
        videov.pause()
    }

    override fun onResume() {
        super.onResume()
        videov.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        nMediaPlayer.release()
    }
}