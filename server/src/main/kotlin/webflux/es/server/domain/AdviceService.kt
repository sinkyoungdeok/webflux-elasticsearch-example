package webflux.es.server.domain

import org.springframework.stereotype.Service
import webflux.es.idl.v1.advice.AdviceSearchRequest
import webflux.es.idl.v1.advice.AdviceSearchResponse
import webflux.es.idl.v1.advice.AdviceServiceGrpcKt

@Service
class AdviceService : AdviceServiceGrpcKt.AdviceServiceCoroutineImplBase() {

    override suspend fun adviceSearch(request: AdviceSearchRequest): AdviceSearchResponse {
        return super.adviceSearch(request)
    }
}