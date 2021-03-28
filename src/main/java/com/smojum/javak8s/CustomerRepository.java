package com.smojum.javak8s;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {

}
