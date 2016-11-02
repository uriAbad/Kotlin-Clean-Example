package uriabad.cleankotlin.domain.model

/**
 * Created by Uri Abad on 28/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */

data class ForecastList(val city: String,
                        val country: String,
                        val dailyForecast: List<Forecast>){
    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}

data class Forecast(val date: String,
                    val description: String,
                    val high: Int,
                    val low: Int,
                    val iconUrl: String)