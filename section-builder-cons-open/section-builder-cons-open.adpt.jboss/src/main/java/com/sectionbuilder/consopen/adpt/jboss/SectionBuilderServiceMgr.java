package com.sectionbuilder.consopen.adpt.jboss;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.inject.Inject;

import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;
import com.ftse.sectionbuilder.consopen.core.SectionBuilderService;

@Singleton
public class SectionBuilderServiceMgr {

	private SectionBuilderService pojoService;

	@Inject
	private CacheAccessIf cache;

	@PostConstruct
	private void startup() {
		// debug noticeably - THIS SHOULD ONLY HAPPEN ONCE
		System.out.println("**********************************************************");
		System.out.println("******** CREATING NEW SECTION BUILDER MGR SINGLETON EJB *************");
		System.out.println("******** Cache Name - " + cache.getName() + " *************");
		System.out.println("**********************************************************");
		
		pojoService = new SectionBuilderService(cache);
	}

	public SectionBuilderService getService() {
		return pojoService;
	}
}
