package com.ftse.sectionbuilder.consopen.core;

import com.ftse.eodinterface.api.cacheaccess.CacheAccessIf;

public class SectionBuilderService {

	private CacheAccessIf cache;

	public SectionBuilderService(CacheAccessIf cache) {
		this.cache = cache;
	}

	public SectionBuilderRs buildSection(String prefix) {
		return new SectionBuilderRs(cache.getName());
	}

	public static class SectionBuilderRs {
		private String cacheName;

		public SectionBuilderRs(String cacheName) {
			super();
			this.cacheName = cacheName;
		}

		public String getCacheName() {
			return cacheName;
		}

		public void setCacheName(String cacheName) {
			this.cacheName = cacheName;
		}
	}
}
