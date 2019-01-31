package com.ftse.eodcache.adpt.jboss.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.ftse.eodcache.adpt.jboss.shared.CacheMgrIf;
import com.ftse.eodcache.lazyload.LazyLoadCache;
import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;

@Singleton
public class InfinispanCacheAccessMgr implements CacheMgrIf {

	private String name = "NOT SET";

	// The one and only cache that is used by all clients
	private CacheAccessIf cache;

	@PostConstruct
	public void postConstruct() {

		// create a name for the cache so that we can verify that is always the same
		// CAche
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LLLL-dd HH:mm:ss");
		name = date.format(formatter);

		// debug noticeably - THIS SHOULD ONLY HAPPEN ONCE
		System.out.println("**********************************************************");
		System.out.println("******** CREATING NEW CACHE ACCESS SINGLETON EJB *************");
		System.out.println("******** Name - " + name + " *************");

		// create the core Inifinispan Cache
		InfinispanCache infinispanCache = new InfinispanCache();

		// Wrap with the Lazy Load functionality.
		cache = new LazyLoadCache(infinispanCache);

		System.out.println("**********************************************************");
	}

	@Override
	public CacheAccessIf getCacheAccess() {
		return this.cache;
	}
}