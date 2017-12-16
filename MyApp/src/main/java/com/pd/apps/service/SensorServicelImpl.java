package com.pd.apps.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pd.apps.model.AirCondition;
import com.pd.apps.model.Appliance;
import com.pd.apps.model.Elevator;
import com.pd.apps.model.Layout;
import com.pd.apps.model.Light;
import com.pd.apps.model.SensorData;
import com.pd.apps.model.SensorHistory;
import com.pd.apps.model.Sensors;
import com.pd.apps.repositories.ApplianceRepository;
import com.pd.apps.repositories.LayoutRepository;
import com.pd.apps.repositories.SensorHistoryRepository;
import com.pd.apps.repositories.SensorRepository;
import com.pd.apps.util.AppConstants;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class SensorServicelImpl implements SensorService{

	@Autowired
	SensorRepository sensorRepository;
	@Autowired
	SensorHistoryRepository sensorHistoryRepository;
	@Autowired
	LayoutRepository layoutRepository;
	@Autowired
	ApplianceRepository applianceRepository;
	
	@Override
	public List<Sensors> getSensorData() {
		return sensorRepository.findAll();
	}
	
	@Override
	public Sensors getSensorData(int id) {
		Sensors data = sensorRepository.findOne(id);
		return data;
	}

	@Override
	public void processSensorData(SensorData data){
		data.parse();
		String sensorId = data.getSensorId();
		SensorHistory hist = new SensorHistory();
		hist.setSensorId(sensorId);
		hist.setRawData(data.getRawData());
		
		int TempSen = 0;
		
		sensorHistoryRepository.save(hist);
		
		List<Appliance> app = getAppliances();
		List<Sensors> sen = getSensorData();
		List<SensorHistory> senHis =  getSensorHistory();
		
		Iterator itHist = senHis.iterator();
		
		while(itHist.hasNext()){
			
			SensorHistory sH = (SensorHistory)itHist.next();
			
			String[] sArray = sH.getRawData().split(",");
			
			if(sArray[1] == AppConstants.TEMP_SENSOR)
			{
				TempSen = TempSen + Integer.parseInt(sArray[2]);
			}
			
		}
		
	double avgTemp = TempSen/senHis.size();
	
	Iterator senItr = sen.iterator();
	Iterator appItr = app.iterator();
	
	while(senItr.hasNext()){
		
		Sensors sensorData  = (Sensors)senItr.next();
		
		//String[] sArray = sH.getRawData().split(",");
		
		if(sensorData.getsId().equals(sensorId))
		{
			if(sensorData.getsType().equals("IN"))
			{
				while(appItr.hasNext()){
					Appliance appData  = (Appliance)appItr.next();
					
					if(appData.getStatus().equals("OFF"))
					{
						appData.setStatus("ON");
						applianceRepository.save(appData);
					}
					
				}
			}
			else
			{
				while(appItr.hasNext()){
					Appliance appData  = (Appliance)appItr.next();
					
					if(appData.getStatus().equals("ON"))
					{
						appData.setStatus("OFF");
						applianceRepository.save(appData);
					}
				}
				
			}
		}
		
	}
	
	
		
		
		
	
	}
	
	@Override
	public void createInitialDataSet(){
		Appliance appl1 = createAppliance("F1L1", "Floor-1 Light-1", "OFF", 100.00, "L");
		Appliance appl2 = createAppliance("F1L2", "Floor-1 Light-2", "OFF", 100.00, "L");
		Appliance appl3 = createAppliance("F2L1", "Floor-2 Light-1", "OFF", 100.00, "L");
		Appliance appl4 = createAppliance("F2L2", "Floor-2 Light-2", "OFF", 100.00, "L");
		
		
		
		applianceRepository.save(appl1);
		applianceRepository.save(appl2);
		applianceRepository.save(appl3);
		applianceRepository.save(appl4);
		
		Layout b1 = createLayout("B1", "Building-1");
		Layout f1 = createLayout("F1", "Building-1");
		Layout f2 = createLayout("F2", "Building-1");
		Layout r1 = createLayout("R1", "Building-1");
		Layout r2 = createLayout("R2", "Building-1");
		Layout r3 = createLayout("R3", "Building-1");
		Layout r4 = createLayout("R4", "Building-1");
		
		layoutRepository.save(b1);
		layoutRepository.save(f1);
		layoutRepository.save(f2);
		layoutRepository.save(r1);
		layoutRepository.save(r2);
		layoutRepository.save(r3);
		layoutRepository.save(r4);
		
		
		Sensors sr1 = createSensor("S1", "Senor-1 ROOM-1","R1");
		Sensors sr2 = createSensor("S2", "Senor-2 ROOM-2","R2");
		Sensors sr3 = createSensor("S3", "Senor-3 ROOM-3","R3");
		Sensors sr4 = createSensor("S4", "Senor-4 ROOM-4","R4");
		Sensors sr5 = createSensor("S5", "Senor-5 FLOOR-1","R1");
		Sensors sr6 = createSensor("S6", "Senor-6 FLOOR-2","R1");
		
		sensorRepository.save(sr1);
		sensorRepository.save(sr2);
		sensorRepository.save(sr3);
		sensorRepository.save(sr4);
		sensorRepository.save(sr5);
		sensorRepository.save(sr6);
		
	}
	
	
	
	private Layout createLayout(String id, String name){
		Layout l = new Layout();
		l.setId(id);
		l.setName(name);
		return l;
	}
	
	private Sensors createSensor(String id, String name, String lid){
		Sensors s = new Sensors();
		s.setsId(id);
		s.setLayoutid(lid);
		s.setsType(name);
		return s;
	}
	
	private Appliance createAppliance(String appId, String appName, String status, double powerRating, String type){
		Appliance appl = null;
		if(type == "L"){
			appl = new Light();
		}
		else if(type == "E"){
			appl = new Elevator();
		}
		else if(type == "A"){
			appl = new AirCondition();
		}
		return appl;
	}

	@Override
	public List<Appliance> getAppliances() {
		return applianceRepository.findAll();
	}
	
	@Override
	public List<SensorHistory> getSensorHistory() {
		return sensorHistoryRepository.findAll();
	}
	
}
