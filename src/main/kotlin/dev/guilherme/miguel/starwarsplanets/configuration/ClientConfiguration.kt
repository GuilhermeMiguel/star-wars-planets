package dev.guilherme.miguel.starwarsplanets.configuration

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class ClientConfiguration {

//    @Bean
//    fun webClient() : WebClient {
//        return WebClient.builder().baseUrl("https://swapi.dev/api/").build()
//    }

    /*
        Ótimo exemplo de configuração de clients no kotlin
        https://www.fabrizioduroni.it/2020/12/23/rest-template-webclient-spring-boot/
     */

    @Bean
    fun restTemplateConfig() : RestTemplate = RestTemplateBuilder()
        .setConnectTimeout(Duration.ofSeconds(10))
        .build()
}