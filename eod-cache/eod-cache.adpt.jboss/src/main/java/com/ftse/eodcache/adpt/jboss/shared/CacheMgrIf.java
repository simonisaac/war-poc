package com.ftse.eodcache.adpt.jboss.shared;

import javax.ejb.Local;

import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;

@Local
public interface CacheMgrIf {

	CacheAccessIf getCacheAccess();
}
