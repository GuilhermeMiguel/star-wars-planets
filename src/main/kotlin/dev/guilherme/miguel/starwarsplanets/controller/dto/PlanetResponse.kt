package dev.guilherme.miguel.starwarsplanets.controller.dto

import dev.guilherme.miguel.starwarsplanets.domain.model.Planet
import java.util.UUID

data class PlanetResponse (var id: UUID?,
                           var name: String,
                           var climate: String,
                           var terrain: String,
                           var exhibitionsInFilms: Int)
{

    constructor(planet: Planet, exhibitionsInFilms: Int)
            : this (
            id = planet.id,
            name = planet.name,
            climate = planet.climate,
            terrain = planet.terrain,
            exhibitionsInFilms
            )

}