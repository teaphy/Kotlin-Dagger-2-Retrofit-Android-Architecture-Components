package com.example.administrator.archdemo.ui.adapter

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.administrator.archdemo.R
import com.example.administrator.archdemo.entity.UserEntity

import org.jetbrains.anko.find

/**
 * @desc
 * @author Teaphy
 * @date 2017/6/11
 */
class UserAdapter(var list: MutableList<UserEntity>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>(){

	override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
		val user = list[position]
		with(user) {
			holder!!.tvId.text = id.toString()
			holder!!.tvName.text = name
			holder!!.tvBrowed.text = isBrrowed.toString()
		}
	}

	override fun getItemCount(): Int {
		return list?.size
	}

	override fun onCreateViewHolder(viewGroup: ViewGroup?, type: Int): MyViewHolder {
		val cotext: Context? = viewGroup?.context
		val view = LayoutInflater.from(cotext).inflate(R.layout.item_user, viewGroup, false)
		return MyViewHolder(view)
	}

	class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
		val tvId: TextView = view.find(R.id.tv_id)
		val tvName: TextView = view.find(R.id.tv_name)
		val tvBrowed: TextView = view.find(R.id.tv_browed)
	}

	fun setUserList(users: MutableList<UserEntity>) {
		if (list.size == 0) {
			list.addAll(users)
			notifyItemRangeInserted(0, users.size)
		} else {
			val result: DiffUtil.DiffResult =DiffUtil.calculateDiff(object: DiffUtil.Callback() {
				override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
					val old = list[oldItemPosition]
					val user = users[newItemPosition]
					return old == user
				}

				override fun getOldListSize(): Int {
					return list.size
				}

				override fun getNewListSize(): Int {
					return users.size
				}

				override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
					val old = list[oldItemPosition]
					val user = users[newItemPosition]
					return old.id == user.id &&
							old.name.equals(user.name) &&
							old.isBrrowed == user.isBrrowed
				}
			})
			list = users
			result.dispatchUpdatesTo(this)
		}
	}
}