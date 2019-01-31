package com.sectionbuilder.consopen.adpt.jboss.cdi;

import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import com.ftse.eodcache.adpt.jboss.shared.CacheMgrIf;
import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;
import com.ftse.sectionbuilder.consopen.core.SectionBuilderService;
import com.sectionbuilder.consopen.adpt.jboss.SectionBuilderServiceMgr;

public class Imports {

	// @Produces
	@EJB(lookup = "java:global/eod-cache.adpt.jboss/InfinispanCacheAccessMgr!com.ftse.eodcache.adpt.jboss.shared.CacheMgrIf")
	private CacheMgrIf cacheMgr;

	@Inject
	private SectionBuilderServiceMgr serviceMgr;

	private Imports() {
		// Disable instantiation of this class
	}

	@Produces
	public CacheAccessIf cache() {
		return cacheMgr.getCacheAccess();
	}

	@Produces
	public SectionBuilderService sectionBuilderService() {
		return serviceMgr.getService();
	}
}