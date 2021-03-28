package com.smojum.javak8s;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Controller
public class CustomerController {
    @Bean
    RouterFunction<ServerResponse> routes(ApplicationContext context,
                                          CustomerRepository customerRepository) {
        return route()
                //get all customers
                .GET("/customers", request -> ok().body(customerRepository.findAll(), Customer.class))
                .GET("/customer/{id}", request -> ok().body(customerRepository.findById(Integer.parseInt(request.pathVariable("id"))), Customer.class))
                .GET("/slow/customers", request -> {
                    var slow = customerRepository.findAll().delayElements(Duration.ofSeconds(5));
                    return ok().contentType(MediaType.TEXT_EVENT_STREAM).body(slow, Customer.class);
                })
                .POST("/down", serverRequest -> {
                    AvailabilityChangeEvent.publish(context, LivenessState.BROKEN);
                    return ok().body(Mono.empty(), Void.class);
                })
                .build();
    }


}
