package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.HolidayModel
import org.hse.template.client.rest.model.Response
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "holidays")
interface HolidaysClient {

    @GetMapping
    fun search(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int
    ): Response<HolidayModel>

    @GetMapping
    fun searchMonth(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
        @RequestParam("month") month: Int,
    ): Response<HolidayModel>

    @GetMapping
    fun searchDay(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
        @RequestParam("month") month: Int,
        @RequestParam("day") day: Int
    ): Response<HolidayModel>

    @GetMapping
    fun searchLocation(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
        @RequestParam("location") location: String
    ): Response<HolidayModel>

    @GetMapping
    fun searchType(
        @RequestParam("api_key") apiKey: String,
        @RequestParam("country") country: String,
        @RequestParam("year") year: Int,
        @RequestParam("type") location: String
    ): Response<HolidayModel>
}
