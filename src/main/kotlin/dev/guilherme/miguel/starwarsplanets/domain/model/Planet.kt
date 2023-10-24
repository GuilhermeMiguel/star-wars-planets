package dev.guilherme.miguel.starwarsplanets.domain.model

import dev.guilherme.miguel.starwarsplanets.controller.dto.PlanetRequest
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.apache.commons.lang3.StringUtils
import java.util.UUID

@Entity(name = "tb_planet")
data class Planet(

        @Id
        @Column(nullable = false)
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: UUID?,

        @Column(nullable = false, length = 50)
        var name: String,

        @Column(nullable = false, length = 30)
        var climate: String,

        @Column(nullable = false, length = 30)
        var terrain: String
)
{

        fun updateComplete(planetRequest: PlanetRequest) {
                this.climate = planetRequest.climate
                this.name = planetRequest.name
                this.terrain = planetRequest.terrain
        }


        fun updatePartial(planetRequest: PlanetRequest) {
                if(StringUtils.isNotEmpty(planetRequest.climate)) this.climate = planetRequest.climate

                if(StringUtils.isNotEmpty(planetRequest.name)) this.name = planetRequest.name

                if(StringUtils.isNotEmpty(planetRequest.climate)) this.climate = planetRequest.climate
        }
}