package dev.guilherme.miguel.starwarsplanets.service

import dev.guilherme.miguel.starwarsplanets.controller.dto.PlanetRequest
import dev.guilherme.miguel.starwarsplanets.controller.dto.PlanetResponse
import java.util.UUID

interface PlanetService {

   fun create(planetRequest: PlanetRequest) : PlanetResponse

   fun findAll() : List<PlanetResponse>

   fun findById(id: UUID) : PlanetResponse

   fun updateComplete(id: UUID, planetRequest: PlanetRequest) : PlanetResponse

   fun updatePartial(id: UUID, planetRequest: PlanetRequest) : PlanetResponse

   fun delete(id: UUID)
}