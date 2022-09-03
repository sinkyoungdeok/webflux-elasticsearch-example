package webflux.es.server.infrastructure

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import reactor.core.publisher.Mono
import webflux.es.server.domain.Advice


interface AdviceSearchRepository {
    fun findAdviceById(id: String): Mono<Advice>
}