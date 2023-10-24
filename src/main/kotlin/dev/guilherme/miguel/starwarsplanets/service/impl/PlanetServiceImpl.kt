package dev.guilherme.miguel.starwarsplanets.service.impl

import dev.guilherme.miguel.starwarsplanets.client.SwApiClient
import dev.guilherme.miguel.starwarsplanets.client.SwApiClientRestTemplate
import dev.guilherme.miguel.starwarsplanets.controller.dto.PlanetRequest
import dev.guilherme.miguel.starwarsplanets.controller.dto.PlanetResponse
import dev.guilherme.miguel.starwarsplanets.domain.model.Planet
import dev.guilherme.miguel.starwarsplanets.domain.repository.PlanetRepository
import dev.guilherme.miguel.starwarsplanets.service.PlanetService
import org.springframework.transaction.annotation.Transactional
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class PlanetServiceImpl(
    private val planetRepository: PlanetRepository,
    private val swApiClient: SwApiClientRestTemplate
) : PlanetService {

    @Transactional
    override fun create(planetRequest: PlanetRequest) : PlanetResponse {
        val planet = planetRequest.toPlanet()

        val exhibitionsInFilms = getExhibitionInFilms(planet.name)

        return PlanetResponse(planetRepository.save(planet), exhibitionsInFilms)

    }

    @Transactional(readOnly = true)
    override fun findAll(): List<PlanetResponse> {
       return planetRepository.findAll()
               .map { PlanetResponse(it, getExhibitionInFilms(it.name)) }

    }


    @Transactional(readOnly = true)
    override fun findById(id: UUID): PlanetResponse {
        val planet = findPlanetById(id)

        val exhibitionsInFilms = getExhibitionInFilms(planet.name)

        return PlanetResponse(planet, exhibitionsInFilms)
    }

    @Transactional
    override fun updateComplete(id: UUID, planetRequest: PlanetRequest): PlanetResponse {
        val planet = findPlanetById(id)
        planet.updateComplete(planetRequest)

        return PlanetResponse(planetRepository.save(planet), getExhibitionInFilms(planet.name))
    }

    @Transactional
    override fun updatePartial(id: UUID, planetRequest: PlanetRequest): PlanetResponse {
        val planet = findPlanetById(id)
        planet.updatePartial(planetRequest)

        return PlanetResponse(planetRepository.save(planet), getExhibitionInFilms(planet.name))
    }


    @Transactional(readOnly = true)
    override fun delete(id: UUID) {
        val planet = findPlanetById(id)

        planetRepository.delete(planet)
    }

    private fun findPlanetById(id: UUID) : Planet {
        return planetRepository.findById(id)
            .orElseThrow { NoSuchElementException("Planet not found with this id : $id") }
    }

    private fun getExhibitionInFilms(name: String): Int {
        return swApiClient.getExhibitions(name).size
    }
}