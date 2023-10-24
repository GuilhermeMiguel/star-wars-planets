package dev.guilherme.miguel.starwarsplanets

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@OpenAPIDefinition(servers = [Server(url = "/", description = "Default Server URL")])
@EnableFeignClients
@SpringBootApplication
class StarWarsPlanetsApplication

fun main(args: Array<String>) {
	runApplication<StarWarsPlanetsApplication>(*args)
}
