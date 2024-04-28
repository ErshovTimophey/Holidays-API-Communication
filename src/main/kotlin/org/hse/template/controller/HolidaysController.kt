package org.hse.template.controller

import org.hse.template.api.HolidaysApi
import org.hse.template.client.rest.api.HolidaysClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HolidaysController(
    private val holidaysClient: HolidaysClient
) : HolidaysApi {
    private val api_key = "rxAAEJkDU1JrlERbjGsThvagR6dZT5mc"

    @GetMapping("/search-holiday/{country}&{year}")
    override fun getHoliday(
        @PathVariable country: String,
        @PathVariable year: Int
    ) = holidaysClient.search(api_key,country, year)

    @GetMapping("/month-holidays/{country}&{year}&{month}")
    override fun holidayByMonth(
        @PathVariable country: String,
        @PathVariable year: Int,
        @PathVariable month: Int
    ) = holidaysClient.searchMonth(api_key,country, year, month).response.holidays

    @GetMapping("/day-holidays/{country}&{year}&{month}&{day}")
    override fun holidayByDay(
        @PathVariable country: String,
        @PathVariable year: Int,
        @PathVariable month: Int,
        @PathVariable day: Int
    ) = holidaysClient.searchDay(api_key,country, year, month, day).response.holidays

    @GetMapping("/location-holiday/{country}&{year}&{location}")
    override fun exactPlaceHolidays(
        @PathVariable country: String,
        @PathVariable year: Int,
        @PathVariable location: String
    ) = holidaysClient.searchLocation(api_key,country, year, location)

    @GetMapping("/type-holiday/{country}&{year}&{type}")
    override fun typeOfHolidays(
        @PathVariable country: String,
        @PathVariable year: Int,
        @PathVariable type: String
    ) = holidaysClient.searchType(api_key, country, year, type)
}