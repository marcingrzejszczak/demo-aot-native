package com.example.demo;

import java.util.Collections;

import com.example.demo.hello.HelloService;
import com.example.demo.hello.SimpleHelloService;
import io.micrometer.observation.ObservationRegistry;
import jakarta.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.observation.HttpRequestsObservationFilter;

@Configuration(proxyBeanMethods = false)
class DemoConfiguration {

	@Bean
	HelloService helloService() {
		return new SimpleHelloService();
	}

	@Bean
	FilterRegistrationBean observationWebFilter(ObservationRegistry observationRegistry) {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new HttpRequestsObservationFilter(observationRegistry));
		filterRegistrationBean.setDispatcherTypes(DispatcherType.ASYNC, DispatcherType.ERROR, DispatcherType.FORWARD,
				DispatcherType.INCLUDE, DispatcherType.REQUEST);
		filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		// We provide a list of URLs that we want to create observations for
		filterRegistrationBean.setUrlPatterns(Collections.singletonList("/foo"));
		return filterRegistrationBean;
	}
}
