package uriabad.cleankotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import uriabad.cleankotlin.domain.model.Forecast
import uriabad.cleankotlin.domain.model.ForecastList
import kotlinx.android.synthetic.main.item_forecast.*
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 * Created by Uri Abad on 24/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>(){

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast[position]){
//            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.size()

    class ViewHolder(view: View, val itemClick: OnItemClickListener): RecyclerView.ViewHolder
    (view){

        fun bindForecast(forecast: Forecast){
            with(forecast){
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.description.text = description
                itemView.date.text = date
                itemView.maxTemperature.text = "$high"
                itemView.minTemperature.text = "$low"
            }
        }
    }
}