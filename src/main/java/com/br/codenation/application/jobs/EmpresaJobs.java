package com.br.codenation.application.jobs;

import com.br.codenation.application.controller.EmpresaController;
import com.br.codenation.application.service.impl.EmpresaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmpresaJobs {


    private Logger LOG = LoggerFactory.getLogger(EmpresaJobs.class);

    @Autowired
    EmpresaServiceImpl empresaService;

    @Scheduled(fixedRate = 10000)
    public void countEmpresa(){
        Long count = empresaService.getCount();

        LOG.info("### START VERIFY COUNT COMPANIES" );
        LOG.info("### FOUND {} COMPANIES IN BASE" , count);
        LOG.info("### END VERIFY COUNT COMPANIES");
    }
}
