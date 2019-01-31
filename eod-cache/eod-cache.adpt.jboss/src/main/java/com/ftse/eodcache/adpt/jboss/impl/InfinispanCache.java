package com.ftse.eodcache.adpt.jboss.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;
import com.ftse.eodinterface.model.entities.Cacheable;

public class InfinispanCache implements CacheAccessIf {
	
	private Map<String, Cacheable> theMap;
	
	private String name;
	
	public InfinispanCache() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LLLL-dd HH:mm:ss");
		this.name = "INFINISPAN CACHE[" + date.format(formatter) + "]";
		this.theMap = new HashMap<>();
		System.out.println("-------------- CREATING NEW INIFINISPAN CACHE ");
		System.out.println("-------------- Name - " + name + " ");
	}

	@Override
	public void put (String key, Cacheable value) {
		this.theMap.put(key, value);
	}

	@Override
	public void setName(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Cacheable get(String key) {
		return this.theMap.get(key);
	}
	
	@Override
	public String cacheState () {
		StringBuilder bil = new StringBuilder();
		this.theMap.forEach((key, value) -> bil.append(" | key:" + key + ", value:" + value));
		return bil.toString();
	}
}