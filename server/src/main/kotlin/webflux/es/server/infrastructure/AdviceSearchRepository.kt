package webflux.es.server.infrastructure

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import webflux.es.server.domain.Advice


interface AdviceSearchRepository : ElasticsearchRepository<Advice, String> {

}