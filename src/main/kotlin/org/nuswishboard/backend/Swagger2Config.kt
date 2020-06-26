package org.nuswishboard.backend

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @description
 * Build a Swagger2 configuration file
 * @author Jwenk
 * @copyright intoDream.io Dream building technology
 * @email xmsjgzs@163.com
 * @date 2019-03-31,21:55
 */
@Configuration
@EnableSwagger2
class Swagger2Config {

    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("NUS Wishboard Backend v1 API")
            .description("A v1 API for project NUS Wishboard.")
            .contact(Contact("NUS Wishboard", "https://github.com/NUSWishboard/backend", "mozongran@gmail.com"))
            .version("1.0.0")
            .build()
    }
}
