package dev.guilherme.miguel.starwarsplanets.client.dto

data class SwApiResponse(
    var results : List<ResultsSwApiResponse>
)

data class ResultsSwApiResponse(
    var films : List<String>
)

