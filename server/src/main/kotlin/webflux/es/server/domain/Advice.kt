package webflux.es.server.domain

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "advices")
class Advice(
    @Id val id: String,
    val title: String,
    val content: String
)