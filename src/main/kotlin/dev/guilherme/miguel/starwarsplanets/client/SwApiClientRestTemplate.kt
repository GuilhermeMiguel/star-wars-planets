package dev.guilherme.miguel.starwarsplanets.client

import dev.guilherme.miguel.starwarsplanets.client.dto.SwApiResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class SwApiClientRestTemplate(val restTemplate: RestTemplate) {

    fun getExhibitions(name: String): List<String> {

        val response =
            restTemplate.getForObject("https://swapi.dev/api/planets/?search=$name", SwApiResponse::class.java)

        if (response?.results != null) {
            return response.results[0].films
        }

        return listOf()
    }
}