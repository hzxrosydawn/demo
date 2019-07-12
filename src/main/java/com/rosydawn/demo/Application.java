package com.rosydawn.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 注解@SpringBootApplication是一个组合注解（@Configuration，@EnableAutoConfiguration，@ComponentScan），
 * 其中@EnableAutoConfiguration注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。由于spring-boot-starter-web 添加了
 * Tomcat和Spring MVC，所以Auto-configuration将假定你正在开发一个web应用，并对Spring进行相应地设置。Auto-configuration设计成可以
 * 跟"Starters"一起很好的使用，但这两个概念没有直接的联系。你可以自由地挑选starters以外的jar依赖，Spring Boot仍会尽最大努力去自动配
 * 置你的应用。
 *
 * 通常建议将应用的main类放到其他类所在包的顶层(root package)，并将@EnableAutoConfiguration注解添加到你的main类上，这样就隐式地定
 * 义了一个基础的包搜索路径（search package） ，以搜索某些特定的注解实体（比如@Service，@Component等）。采用root package方式，你就
 * 可以使用@ComponentScan注解而不需要指定basePackage属性（@ComponentScan默认会扫描与配置类相同的包）。也可以使用
 * @SpringBootApplication注解，只要将main类放到root package中。一般建议将入口类放在groupId+artifactId组合的包名下。
 *
 * 如果部署到其他Web容器中，则需要一个SpringBootServletInitializer实现类，并重写configure方法，这样将使用Spring框架的Servlet 3.0
 * 支持，并允许通过Servlet容器来配置Web应用。一般使用包含main方法的入口类来实现SpringBootServletInitializer。
 *
 * 实现自动配置有两种可选方式，分别是使用@SpringBootApplication注解，货后则将@EnableAutoConfiguration添加到一个@Configuration类上。
 *
 * 如果发现启用了不想要的自动配置项，你可以使用@EnableAutoConfiguration注解（配合@Configuration注解）来exclude属性禁用它们。如果该
 * 类不在classpath中，你可以使用该注解的excludeName属性，并指定全限定名来达到相同效果。最后，你可以通过
 * spring.autoconfigure.exclude属性exclude多个自动配置项（一个自动配置项集合） 。
 */
@SpringBootApplication
@MapperScan("com.rosydawn.demo.**.dao")
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    /**
     * main方法通过调用 run ，将业务委托给了Spring Boot的SpringApplication类。SpringApplication将引导我们的应用，启动Spring，
     * 相应地启动被自动配置的Tomcat web服务器。需要将当前类对象作为参数传递给run方法，以告诉SpringApplication谁是主要的Spring组件，
     * 并传递args数组以暴露所有的命令行参数。
     *
     * 也可以使用application.properties外化配置文件来配置SpringApplication。
     */
    public static void main(String[] args) throws Exception {
        // --- 如果不喜欢默认的SpringApplication，也可以自定义其行为 ---
        // 如果配置只有一行，可以直接使用静态的run方法
        // SpringApplication.run(MySpringConfiguration.class, args);
        // 如果配置需要多行，则需要创建SpringApplication对象发，然后调用一系列setXxx方法
        // SpringApplication app = new SpringApplication(MySpringConfiguration.class);
        SpringApplication springApplication = new SpringApplication();
        springApplication.setWebApplicationType(WebApplicationType.SERVLET);
        SpringApplication.run(Application.class, args);
    }
}