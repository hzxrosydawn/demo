package com.rosydawn.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置类。@EnableSwagger2 注解表示此项目启用 Swagger API 文档。
 *
 * @auther: Vincent Huang
 * Created on 2019/7/4 10:20
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Docket（Swagger API 摘要）是 Springfox 框架的基础类，提供一些配置接口文档的默认属性及便捷方法。
     */
    @Bean
    public Docket swaggerApi() {
        // 指定 API 文档类型为最新的 Swagger 2 类型
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定 API 的元信息
                .apiInfo(setApiInfo())
                // 实例化一个 ApiSelectorBuilder，用于创建 API Selector。可链式调用多个方法。
                .select()
                // .apis() 方法的参数类型 Predicate<T> （Java 8新增的概念）代表一个特定的条件，即断言。
                // 指定需要扫描的包路径，只有此路径下的 Controller 类才会自动生成 Swagger API 文档。
                .apis(RequestHandlerSelectors.basePackage("com.rosydawn.demo"))
                // 指定符合的路径
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置页面展示的基本信息，包括：标题、描述、版本、服务条款、联系方式等，查看 ApiInfo 类的源码还会发现支持 license 配置等。
     * 以上信息皆可在此方法进行配置，也可以使用默认值。配置完成之后启动项目，在浏览器中输入网址
     * http://localhost:8080/swagger-ui.html，即可看到上面的配置信息。
     */
    private ApiInfo setApiInfo() {
        return new ApiInfoBuilder()
                .title("XXX平台")
                .description("XXX平台 API 1.0 操作文档")
                .version("1.0")
                // 服务条款网址
                .termsOfServiceUrl("http://www.rosydawn.site")
                .contact(new Contact("Vincent Huang", "http://www.rosydawn.site/", "hzxrosydawn@163.com"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
