package org.hse.template.client.rest.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

@Schema(description = "Информация о списке праздников")
class HolidayModel(
    @Schema(description = "Список найденных праздников")
    val holidays: List<Holiday>
){}
