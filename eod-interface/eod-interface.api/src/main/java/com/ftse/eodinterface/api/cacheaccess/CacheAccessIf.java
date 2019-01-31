package com.ftse.eodinterface.api.cacheaccess;

import com.ftse.eodinterface.model.entities.Cacheable;

public interface CacheAccessIf {

	Cacheable get (String subject);
	
	void setName(String name);

	String getName();

	void put(String key, Cacheable value);

	String cacheState();
}
