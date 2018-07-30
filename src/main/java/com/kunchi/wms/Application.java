package com.kunchi.wms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * mybatis-plus Spring Boot 测试 Demo<br>
 * 文档：http://mp.baomidou.com<br>
 */
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.kunchi.wms.config",
        "com.kunchi.wms.controller",
        "com.kunchi.wms.service"})
@EnableSwagger2
public class Application {

    protected final static Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        logger.info("PortalApplication is success!");
        System.err.println("sample started. http://localhost:8080/test");
    }


    @Bean
    public Docket document() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("WMS-Demo，分布式web服务如此简单。")
                .version("1.0")
                .build();
    }

    // 这个类可以让启动之后，控制台输出一行明显的提示，一般可以用于监控的钩子。
    @Bean
    CommandLineRunner sampleCommandLineRunner() {
        return (args) -> System.out.println("#项目启动运行！");
    }



}
