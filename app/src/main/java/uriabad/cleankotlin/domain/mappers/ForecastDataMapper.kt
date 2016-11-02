package uriabad.cleankotlin.domain.mappers

import uriabad.cleankotlin.data.Forecast
import uriabad.cleankotlin.data.ForecastResult
import uriabad.cleankotlin.domain.model.ForecastList
import java.text.DateFormat
import java.util.*
import uriabad.cleankotlin.domain.model.Forecast as ModelForecast

/**
 * Created by Uri Abad on 28/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(
                city = forecast.city.name,
                country = forecast.city.country,
                dailyForecast = convertForecastListToDomain(forecast.list))
    }

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map {
            convertForecastItemToDomain(it)
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(
                date = convertDate(forecast.dt),
                description = forecast.weather[0].description,
                high = forecast.temp.max.toInt(),
                low = forecast.temp.min.toInt(),
                iconUrl = generateIconUrl(forecast.weather[0].icon)
        )
    }

    private fun convertDate(date: Long): String {
        val df= DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

    private fun generateIconUrl(iconCode: String) = "http://openweathermap.org/img/$iconCode.png"
}