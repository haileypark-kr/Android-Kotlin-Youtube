package com.fastcampuskotlin.youtube.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.fastcampuskotlin.youtube.R
import com.fastcampuskotlin.youtube.YoutubeItem

// adapter: 데이터를 받아서 관리하고 어댑터 뷰에 출력할 수 있는 형태로 데이터를 제공하는 객체
// 이미 있는 Adapter 상속
class YoutubeListAdapter(
	val youtubeItemList: ArrayList<YoutubeItem>,
	val inflater: LayoutInflater,
	val glide: RequestManager, // RequestMapper의 라이브러리 이름이 glide임
	val context: Context

) : RecyclerView.Adapter<YoutubeListAdapter.ViewHolder>() {


	//
	/*
	view holder: 개별 데이터에 대응. 이미 있는 ViewHolder 상속
	현재 화면에 보이는 아이템 레이아웃 개수만큼 생성
	새롭게 그려져야 할 아이템 레이아웃이 있다면(스크롤 동작) 가장 위의 ViewHolder를 재사용해서 데이터만 바꿈
	 */
	inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		val title: TextView
		val thumbnail: ImageView
		val content: TextView

		init {
			title = itemView.findViewById(R.id.title)
			thumbnail = itemView.findViewById(R.id.thumbnail)
			content = itemView.findViewById(R.id.content)
		}


	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(inflater.inflate(R.layout.youtube_list_item, parent, false))
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.title.text = youtubeItemList[position].title
		holder.content.text = youtubeItemList[position].content
		glide.load(youtubeItemList[position].thumbnail)
			.centerCrop()
			.into(holder.thumbnail) // glide 사용하여 이미지 넣어주기
	}

	override fun getItemCount(): Int {
		return youtubeItemList.size
	}
}