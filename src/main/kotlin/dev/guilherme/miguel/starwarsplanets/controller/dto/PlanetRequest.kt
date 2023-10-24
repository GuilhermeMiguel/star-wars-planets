package dev.guilherme.miguel.starwarsplanets.controller.dto

import dev.guilherme.miguel.starwarsplanets.domain.model.Planet

data class PlanetRequest (
    val name: String,
    val climate: String,
    val terrain: String
) {

    fun toPlanet() : Planet {
        return Planet(null, name, climate, terrain)
    }
}
