package com.fastcampuskotlin.youtube

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)


		val retrofit = Retrofit.Builder()
			.baseUrl("http://mellowcode.org/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()

		// Create an implementation of the API endpoints defined by the interface.
		val retrofitService = retrofit.create(RetrofitService::class.java)


		retrofitService.getYoutubeItemList()
			.enqueue(object : Callback<ArrayList<YoutubeItem>> {
				// object 키워드?
				// 이 익명객체는 Vehicle 인터페이스를 상속받은 클래스를 객체로 생성된 것을 의미합니다.
				// 익명객체이기 때문에 클래스 이름은 없고, 구현부는 {...} 안에 정의해야 합니다.

				override fun onResponse(
					call: Call<ArrayList<YoutubeItem>>,
					response: Response<ArrayList<YoutubeItem>>
				) {
					Log.d(TAG, "onResponse: $response")
				}

				override fun onFailure(call: Call<ArrayList<YoutubeItem>>, t: Throwable) {
					Log.d(TAG, "onFailure: $t")
				}

			})
	}


	companion object {
		private const val TAG = "MainActivity"
	}
}