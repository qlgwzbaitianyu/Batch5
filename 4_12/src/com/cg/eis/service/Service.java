package com.cg.eis.service;


class Service {
	interface EmpService{
		String providedService();
	}

}


class EmpService implements Service.EmpService{
	public String providedService() {
		
		return "the insurance service";
	}
}



