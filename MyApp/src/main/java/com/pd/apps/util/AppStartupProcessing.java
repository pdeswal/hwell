package com.pd.apps.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.pd.apps.service.SensorService;


@Component
public class AppStartupProcessing implements BeanFactoryPostProcessor{

	@Autowired
	SensorService sensorService;
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
			throws BeansException {
		
		System.out.println("post processsor");
		
		sensorService.createInitialDataSet();
		
	}
	
	

}
