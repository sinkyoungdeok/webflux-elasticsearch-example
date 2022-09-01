package webflux.es.server.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.reactive.ReactiveElasticsearchClient
import org.springframework.data.elasticsearch.client.reactive.ReactiveRestClients
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchOperations
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchTemplate
import org.springframework.data.elasticsearch.core.convert.ElasticsearchConverter
import org.springframework.data.elasticsearch.core.convert.MappingElasticsearchConverter
import org.springframework.data.elasticsearch.core.mapping.SimpleElasticsearchMappingContext


@Configuration
class ElasticsearchConfig {

    @Bean
    fun reactiveElasticsearchClient(): ReactiveElasticsearchClient? {
        val clientConfiguration: ClientConfiguration =
            ClientConfiguration.builder().connectedTo(elassandraHostAndPort)
                .withSocketTimeout(60000).withConnectTimeout(60000).build()
        return ReactiveRestClients.create(clientConfiguration)
    }

    @Bean
    fun elasticsearchConverter(): ElasticsearchConverter? {
        return MappingElasticsearchConverter(elasticsearchMappingContext())

    }

    @Bean
    fun elasticsearchMappingContext(): SimpleElasticsearchMappingContext? {
        return SimpleElasticsearchMappingContext()
    }

    @Bean
    fun reactiveElasticsearchOperations(): ReactiveElasticsearchOperations? {
        return ReactiveElasticsearchTemplate(
            reactiveElasticsearchClient(), elasticsearchConverter()
        )
    }

    @Value("\${spring.elasticsearch.uris}")
    private val elassandraHostAndPort: String? = null
}