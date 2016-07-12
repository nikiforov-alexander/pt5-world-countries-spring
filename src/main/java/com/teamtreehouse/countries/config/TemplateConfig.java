package com.teamtreehouse.countries.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
public class TemplateConfig {
    // settings from spring with hibernate-giflib
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setPrefix("classpath:/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("LEGACYHTML5");
    return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        final SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.addTemplateResolver(templateResolver());
        return springTemplateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        return viewResolver;
    }
    // setting from spring-basics teachers notes
//      @Bean
//      public ThymeleafViewResolver viewResolver() {
//          ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//          viewResolver.setTemplateEngine(templateEngine());
//          return viewResolver;
//      }
//
//      @Bean
//      public SpringTemplateEngine templateEngine() {
//          SpringTemplateEngine engine = new SpringTemplateEngine();
//          engine.setTemplateResolver(templateResolver());
//          return engine;
//      }
//
//      @Bean
//      public ServletContextTemplateResolver templateResolver() {
//          ServletContextTemplateResolver templateResolver =
//                  new ServletContextTemplateResolver();
//          templateResolver.setPrefix("/templates/");
//          templateResolver.setSuffix(".html");
//          templateResolver.setTemplateMode("HTML5");
//          templateResolver.setOrder(1);
//          return templateResolver;
//      }
}
