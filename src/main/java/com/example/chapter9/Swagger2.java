package com.example.chapter9;

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

// @Configuration註解，讓Spring來加載該類配置
@Configuration
// @EnableSwagger2註解來啟用Swagger2
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // createRestApi函數創建Docket的Bean之後，apiInfo()用來創建該Api的基本信息
                .apiInfo(apiInfo())
                .select()
                // select()返回一個ApiSelectorBuilder實例用來控制哪些接口暴露給Swagger來展現
                // 這邊採用路徑，Swagger會掃描該路徑下所有Controller定義的API，並產生文檔內容
                //（除了被 @ApiIgnore 指定的請求）
                .apis(RequestHandlerSelectors.basePackage("com.example.chapter9.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // Api的基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot Swagger2的集成和使用")
                .description("部落格：https://github.com/yucheng880730")
                .termsOfServiceUrl("https://github.com/yucheng880730")
                .contact((new Contact("Leo", "https://github.com/yucheng880730", "yucheng2k13@gmail.com")))
                .version("1.0")
                .build();
    }

}
