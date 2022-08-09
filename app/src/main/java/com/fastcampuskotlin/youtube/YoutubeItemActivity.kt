package com.fastcampuskotlin.youtube

import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class YoutubeItemActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_youtube_item)


		val videoUrl = intent.getStringExtra("video_url")

		//비디오뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤바'를 붙여주는 작업
		// MediaController는 많이 사용하지 않고 보통 exoplayer 많이 씀.
		// - exoplayer는 DRM 기능 제공 (디지털 저작권)
		val mediaController = MediaController(this)

		(findViewById<VideoView>(R.id.video_youtube)).apply {
			Log.d("YoutubeItemActivity", "$videoUrl")

			this.setVideoPath(videoUrl)
			this.requestFocus() // focus 올라와 있는 애 준비하는 과정을 미리함
			this.start() // 영상 재생

			mediaController.show() // 왜 또 하냐
		}
	}
}