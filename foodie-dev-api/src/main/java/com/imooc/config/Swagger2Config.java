package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    // swagger-ui.html 原路径
    // doc.html 新路径

    // 配置Swagger2核心配置docket
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)         // 指定api类型为swagger2

                .apiInfo(apiInfo()) // 定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.imooc.controller")) // 指定Controller包
                .paths(PathSelectors.any()) // 包下的所有controller
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("电商平台接口api")
                .contact(new Contact(
                        "imooc",
                        "https://www.imooc.com",
                        "food@imooc.com"
                ))
                .description("专为food电商提供的api文档")
                .version("1.0.1") // 文档版本号
                .termsOfServiceUrl("https://www.imooc.com")
                .build();
    }
}
