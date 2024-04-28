package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.model.Holiday
import org.hse.template.client.rest.model.HolidayModel
import org.hse.template.client.rest.model.Response

interface HolidaysApi {

    @Tag(name = "Получение праздников за указанный год в указанной стране")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun getHoliday(

        @Schema(
            description = "Праздник в стране",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
        description = "Год праздника",
        defaultValue = "2019"
        )
        year: Int = 2019,
    ): Response<HolidayModel>

    @Tag(name = "Получение праздников указанной страны за указанный месяц")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun holidayByMonth(
        @Schema(
            description = "Праздник в стране",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
            description = "Год праздника",
            defaultValue = "2024"
        )
        year: Int = 2019,
        @Schema(
            description = "Месяц праздника",
            defaultValue = "5"
        )
        month: Int = 1,
    ): List<Holiday>

    @Tag(name = "Получение праздников указанной страны в определённую дату")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun holidayByDay(
        @Schema(
            description = "Праздник в стране",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
            description = "Год праздника",
            defaultValue = "2019"
        )
        year: Int = 2019,
        @Schema(
            description = "Месяц праздника",
            defaultValue = "1"
        )
        month: Int = 1,
        @Schema(
            description = "День праздника",
            defaultValue = "1"
        )
        day: Int = 1
    ): List<Holiday>

    @Tag(name = "Получение праздников указанной страны в определённом регионе, список регионов(https://calendarific.com/supported-countries)")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun exactPlaceHolidays(

        @Schema(
            description = "Праздник в стране",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
            description = "Год праздника",
            defaultValue = "2019"
        )
        year: Int = 2019,
        @Schema(
            description = "Локация",
            defaultValue = "us-ny"
        )
        location: String = "us-ny"
    ): Response<HolidayModel>

    @Tag(name = "Получение праздников указанной страны по определённому типу праздника")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun typeOfHolidays(

        @Schema(
            description = "Праздник в стране",
            defaultValue = "US"
        )
        country: String = "US",
        @Schema(
            description = "Год праздника",
            defaultValue = "2019"
        )
        year: Int = 2019,
        @Schema(
            description = "Тип",
            defaultValue = "national"
        )
        type: String = "national"
    ): Response<HolidayModel>
}