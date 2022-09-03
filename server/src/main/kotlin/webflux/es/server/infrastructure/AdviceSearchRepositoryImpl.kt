package webflux.es.server.infrastructure

import reactor.core.publisher.Mono
import webflux.es.server.domain.Advice

class AdviceSearchRepositoryImpl : AdviceSearchRepository {
    override fun findAdviceById(id: String): Mono<Advice> {
        TODO("Not yet implemented")
    }
}