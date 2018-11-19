package com.docker2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描Mybatis mapper包路径
@MapperScan(basePackages = "com.docker2.mapper")
public class Docker2Application {

	public static void main(String[] args) {
		SpringApplication.run(Docker2Application.class, args);
	}

	/**
	 * 配置拦截器
	 * 由于添加拦截器需要继承WebMvcConfigurerAdapter类
	 * 需要用@Bean将MyInterceptor注入容器，才能在拦截器中注入，否为注入为空
	 * 或者在自定义拦截器类上加上@Component注解，通过注入方式配置
	 */
	@Configuration
	class WebMvcConfigurer extends WebMvcConfigurerAdapter {

		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			//开发环境：项目根目录\\target\\classes\\upload
			//registry.addResourceHandler("/upload/**").addResourceLocations("classpath:upload/");
			//生产环境：jar包所在目录\\upload
			registry.addResourceHandler("/upload/**").addResourceLocations("file:upload/");
			super.addResourceHandlers(registry);
		}
	}
}
