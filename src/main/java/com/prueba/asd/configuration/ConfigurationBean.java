package com.prueba.asd.configuration;

import com.prueba.asd.controller.ActivoFijoController;
import com.prueba.asd.repository.ActivoFijoRepository;
import com.prueba.asd.repository.TipoActivoFijoRepository;
import com.prueba.asd.service.ActivoFijoService;
import com.prueba.asd.service.TipoActivoFijoService;
import com.prueba.asd.service.impl.ActivoFijoServiceImpl;
import com.prueba.asd.service.impl.TipoActivoFijoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {
//    @Bean
//    public Validation validation(){
//        return new Validation();
//    }

    @Bean
    public ModelMapper mapper(){ return new ModelMapper(); }

    @Bean
    public ActivoFijoService activoFijoService(ModelMapper mapper, ActivoFijoRepository activoFijoRepository,
                                               TipoActivoFijoRepository tipoActivoFijoRepository){
        return  new ActivoFijoServiceImpl(activoFijoRepository,mapper,tipoActivoFijoRepository);
    }

    @Bean
    public TipoActivoFijoService tipoActivoFijoService(ModelMapper mapper, TipoActivoFijoRepository tipoActivoFijoRepository){
        return  new TipoActivoFijoServiceImpl(tipoActivoFijoRepository,mapper);
    }



}
