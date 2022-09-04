package webflux.es.server.infrastructure

import org.apache.http.HttpEntity
import org.apache.http.entity.ContentType
import org.apache.http.nio.entity.NStringEntity
import org.apache.http.util.EntityUtils
import org.elasticsearch.client.RestClient
import reactor.core.publisher.Mono
import webflux.es.server.domain.Advice
import java.util.Collections

class AdviceSearchRepositoryImpl(
    val restClient: RestClient
) : AdviceSearchRepository {
    override fun findAdviceById(id: String): Mono<Advice> {
        val params: Map<String, String> = Collections.singletonMap("pretty", "true")
        val query = "{" +
                " \"from\": 0, " +
                " \"size\": 15," +
                " \"query\": {" +
                "   \"bool\": {" +
                "     \"must\": [" +
                "       {" +
                "         \"query_string\": {" +
                "           \"query\": \"text:엘라스틱서치\"" +
                "         }" +
                "       }" +
                "     ]," +
                "     \"filter\": {" +
                "       \"query_string\": {" +
                "         \"query\": \"date:2019-01-01\"" +
                "       }" +
                "     }" +
                "   }" +
                " }" + "}"
        val entity: HttpEntity = NStringEntity(query, ContentType.APPLICATION_JSON)
        val response = restClient.performRequest("GET", "/myIndex/_search", params, entity)
        val responseBody: String = EntityUtils.toString(response.getEntity())

        TODO("Not yet implemented")
    }
}