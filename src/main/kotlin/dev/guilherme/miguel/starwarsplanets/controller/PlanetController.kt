package dev.guilherme.miguel.starwarsplanets.controller

import dev.guilherme.miguel.starwarsplanets.controller.dto.PlanetRequest
import dev.guilherme.miguel.starwarsplanets.controller.dto.PlanetResponse
import dev.guilherme.miguel.starwarsplanets.service.PlanetService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.util.UUID

@RestController
@RequestMapping("/planets")
@Tag(name = "Simulate Controller", description = "RESTful API for manage star wars planets.")
class PlanetController(private val planetService: PlanetService) {

    @PostMapping
    @Operation(summary = "Register a planet")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Operation successful")
    ])
    fun create(@RequestBody planetRequest: PlanetRequest): ResponseEntity<PlanetResponse> {

        val planet = planetService.create(planetRequest)

        val location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(planet.id)
                .toUri()

        return ResponseEntity.created(location).body(planet)
    }


    @GetMapping
    @Operation(summary = "Get all planets")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Operation successful")
    ])
    fun findAll(): ResponseEntity<List<PlanetResponse>> {

        val planets = planetService.findAll()

        return ResponseEntity.ok(planets)
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a planet by id")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Operation successful")
    ])
    fun findByID(@PathVariable  id: UUID): ResponseEntity<PlanetResponse> {

        val planet = planetService.findById(id)

        return ResponseEntity.ok(planet)
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update all fields of a planet", description = "Update the data of an existing planet based on its ID.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Planet updated successfully"),
        ApiResponse(responseCode = "404", description = "Planet not found"),
        ApiResponse(responseCode = "422", description = "Invalid planet data provided")
    ])
    fun updateComplete(@PathVariable id: UUID, @RequestBody planetRequest: PlanetRequest): ResponseEntity<PlanetResponse> {

        val planet = planetService.updateComplete(id, planetRequest)

        return ResponseEntity.ok(planet)
    }


    @PatchMapping("/{id}")
    @Operation(summary = "Update a planet's chosen fields", description = "Update the data of an existing planet based on its ID.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Planet updated successfully"),
        ApiResponse(responseCode = "404", description = "Planet not found"),
        ApiResponse(responseCode = "422", description = "Invalid planet data provided")
    ])
    fun updatePartial(@PathVariable id: UUID, @RequestBody planetRequest: PlanetRequest): ResponseEntity<PlanetResponse> {

        val planet = planetService.updatePartial(id, planetRequest)

        return ResponseEntity.ok(planet)
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a planet", description = "Delete an existing planet based on its ID.")
    @ApiResponses(value = [
        ApiResponse(responseCode = "204", description = "Planet deleted successfully"),
        ApiResponse(responseCode = "404", description = "Planet not found")
    ])
    fun delete(@PathVariable id: UUID): ResponseEntity<Void> {

        planetService.delete(id)

        return ResponseEntity.noContent().build()
    }
}