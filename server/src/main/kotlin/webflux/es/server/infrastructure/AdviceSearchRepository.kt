package webflux.es.server.infrastructure

import reactor.core.publisher.Mono
import webflux.es.server.domain.Advice


interface AdviceSearchRepository {
    fun findAdviceById(id: String): Mono<Advice>
}