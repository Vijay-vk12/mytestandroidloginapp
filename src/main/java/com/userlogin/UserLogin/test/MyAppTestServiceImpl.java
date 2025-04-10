package com.userlogin.UserLogin.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyAppTestServiceImpl {
	
	@Autowired 
	MyAppTestDaoImpl myAppTestDaoImpl;
	
	public boolean saveData(MyAppTestEntity myAppTestEntity) {
		return myAppTestDaoImpl.saveData(myAppTestEntity);
	}

}
