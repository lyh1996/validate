package com.tuya.pixiu.starter;

import com.tuya.basic.dubbo.ext.monitor.DubboStatusChecker;
import com.tuya.basic.mq.impl.MqKafkaProducer;
import com.tuya.sigmax.client.consumer.GrpcConsumerService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.beans.Introspector;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 从当前 classpath 读取 @DubboService 注解的类
 *
 * @author: 张帅
 **/
@Configuration
// 通过 BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry 可以将 Bean 动态注入容器
// 通过 BeanFactoryAware 可以自动注入 BeanFactory
public class DubboLoaclBeanConfiguration implements BeanDefinitionRegistryPostProcessor, BeanFactoryAware {

    private BeanFactory beanFactory;
    @MockBean
    MqKafkaProducer mqKafkaProducer;
    @MockBean
    DubboStatusChecker dubboStatusChecker;
    @MockBean
    GrpcConsumerService grpcConsumerService;


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        // 自定义 Scanner 扫描 classpath 下的指定注解
        DubboServiceAnnotationScanner scanner = new DubboServiceAnnotationScanner(registry);
//        DubboReferenceAnnotationScanner referenceScanner = new DubboReferenceAnnotationScanner(registry);

        try {
            List<String> packages = AutoConfigurationPackages.get(this.beanFactory); // 获取包路径
            packages = packages.stream().map(o -> o.substring(0, o.lastIndexOf("."))).collect(Collectors.toList());
            for (String pkg : packages) {
                System.out.println("Using auto-configuration base package:" + pkg);
            }
//            referenceScanner.doScan(StringUtils.toStringArray(packages)); // 扫描所有加载的包
            scanner.doScan(StringUtils.toStringArray(packages)); // 扫描所有加载的包
        } catch (IllegalStateException ex) {
            System.err.println("could not determine auto-configuration package, automatic fake scanning disabled." + ex);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        // empty
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    private static class DubboServiceAnnotationScanner extends ClassPathBeanDefinitionScanner {

        DubboServiceAnnotationScanner(BeanDefinitionRegistry registry) {
            super(registry, false);
            // 设置过滤器。仅扫描 @DubboService
            addIncludeFilter(new AnnotationTypeFilter(DubboService.class));

        }

        @Override
        public Set<BeanDefinitionHolder> doScan(String... basePackages) {
            List<String> dubboClassNames = new ArrayList<>();
            // 扫描全部 package 下 annotationClass 指定的 Bean
            Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
            return beanDefinitions;
        }

        String buildDefaultBeanName(String beanClassName) {
            Assert.state(beanClassName != null, "No bean class name set");
            String shortClassName = ClassUtils.getShortName(beanClassName);
            return Introspector.decapitalize(shortClassName);
        }

    }


}
