package com.csc340.travelbuddy.tb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService {

    @Autowired
    ServicesRepository servicesRepository;

    public Object getAllServices() { return servicesRepository.findAll(); }

    public void addNewService(Services services) {
        servicesRepository.save(services);
    }
}
