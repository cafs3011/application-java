package com.br.codenation.application;
import com.br.codenation.application.annotations.AnnotationMethod;
import com.br.codenation.application.annotations.Coluna;
import com.br.codenation.application.controller.EmpresaController;
import com.br.codenation.application.domain.entity.Empresa;
import com.br.codenation.application.service.impl.FileServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SpringBootTest
class ApplicationTests {
	private Logger LOG = LoggerFactory.getLogger(EmpresaController.class);

	@Test
	void contextLoads() {
	}

	@Test
	void imprimirAnnotation() {
		FileServiceImpl fileService = new FileServiceImpl();
		for (Method declaredMethod :
				fileService.getClass().getDeclaredMethods()) {
			if (declaredMethod.getAnnotation(AnnotationMethod.class) != null) {
				LOG.info(declaredMethod.getAnnotation(AnnotationMethod.class).text());
				assert (declaredMethod.getAnnotation(AnnotationMethod.class).text().equals("teste"));
			}
		}
	}

	@Test
	void imprimirAnnotationEmpresa() {
		for (Field declaredField :
				Empresa.class.getDeclaredFields()) {
			if (declaredField.getAnnotation(Coluna.class) != null) {
				LOG.info(declaredField.getAnnotation(Coluna.class).text());
			}
		}
	}

}
