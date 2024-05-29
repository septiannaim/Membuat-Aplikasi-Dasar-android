package com.example.myappscars.Cars

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myappscars.DetailActivity
import com.example.myappscars.R


class CarsAdapter(private val listCars:  ArrayList<Cars>):
    RecyclerView.Adapter<CarsAdapter.CarsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_view_holder_layout, parent, false )
        return CarsViewHolder(view)
    }
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        holder.tvName.text = listCars[position].name
        holder.tvDetail.text = "${listCars[position].detail.substring(0, 30)}..."
        holder.tvasal.text = listCars[position].asal
        Glide.with(holder.itemView.context)
            .load(listCars[position].img)
            .into(holder.imgAsal)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_NAME, listCars[position].name)
            intent.putExtra(DetailActivity.EXTRA_ASAL, listCars[position].asal)
            intent.putExtra(DetailActivity.EXTRA_DETAIL, listCars[position].detail)
            intent.putExtra(DetailActivity.EXTRA_IMG, listCars[position].img)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listCars.size

    inner class CarsViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val tvName = itemView.findViewById(R.id.tv_nama) as TextView
        val tvDetail = itemView.findViewById(R.id.tv_detail) as TextView
        val imgAsal = itemView.findViewById(R.id.img_asal) as ImageView
        val tvasal = itemView.findViewById(R.id.tv_asal) as TextView
    }
}