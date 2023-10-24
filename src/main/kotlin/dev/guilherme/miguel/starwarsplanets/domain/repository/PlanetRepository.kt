package dev.guilherme.miguel.starwarsplanets.domain.repository

import dev.guilherme.miguel.starwarsplanets.domain.model.Planet
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PlanetRepository : JpaRepository<Planet, UUID>