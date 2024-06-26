/*
 * Copyright (c) 2015-2023, David A. Bauer. All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.actor4j.jcache.spi;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.Configuration;

public class LocalActorCacheManager {
	public CacheManager underlyingCacheManager() {
		return Caching.getCachingProvider().getCacheManager();
	}
	
	public <K, V, C extends Configuration<K, V>> Cache<K, V> createCache(String cacheName, C configuration) {
		return underlyingCacheManager().createCache(cacheName, configuration);
	}
}
