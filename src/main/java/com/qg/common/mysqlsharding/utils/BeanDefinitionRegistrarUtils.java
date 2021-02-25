package com.qg.common.mysqlsharding.utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class BeanDefinitionRegistrarUtils implements ImportBeanDefinitionRegistrar {

    private static BeanDefinitionRegistry beanDefinitionRegistry;

    public static void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinition);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        this.beanDefinitionRegistry = registry;
    }
}
