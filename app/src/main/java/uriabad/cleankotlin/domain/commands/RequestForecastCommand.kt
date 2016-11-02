package uriabad.cleankotlin.domain.commands

import uriabad.cleankotlin.data.ForecastRequest
import uriabad.cleankotlin.domain.mappers.ForecastDataMapper
import uriabad.cleankotlin.domain.model.ForecastList

/**
 * Created by Uri Abad on 28/10/2016.
 * Seidor S.A.
 * oabad@seidor.es
 */
class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}