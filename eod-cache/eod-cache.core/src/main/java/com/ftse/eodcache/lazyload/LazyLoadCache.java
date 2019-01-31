package com.ftse.eodcache.lazyload;

import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;
import com.ftse.eodinterface.model.entities.Cacheable;

public class LazyLoadCache implements CacheAccessIf {

	private CacheAccessIf deletegatedToCache;

	public LazyLoadCache(CacheAccessIf delegatedCache) {
		this.deletegatedToCache = delegatedCache;
	}

	@Override
	public Cacheable get(String subject) {
		return deletegatedToCache.get(subject);
	}

	@Override
	public void setName(String name) {
		deletegatedToCache.setName(name);
	}

	@Override
	public String getName() {
		return deletegatedToCache.getName();
	}

	@Override
	public void put(String key, Cacheable value) {
		deletegatedToCache.put(key, value);
	}

	@Override
	public String cacheState() {
		return deletegatedToCache.cacheState();
	}
}
