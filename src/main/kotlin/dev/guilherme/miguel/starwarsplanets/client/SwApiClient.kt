package dev.guilherme.miguel.starwarsplanets.client

import dev.guilherme.miguel.starwarsplanets.client.dto.SwApiResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "SwApi", url = "https://swapi.dev/api/")
interface SwApiClient {

    @GetMapping("planets")
    fun getExhibitions(@PathVariable("search") search: String): SwApiResponse

}