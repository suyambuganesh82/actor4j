/*
 * Copyright (c) 2015-2024, David A. Bauer. All rights reserved.
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
package io.actor4j.dataformat.json.jackson;

import java.lang.reflect.Type;

import com.fasterxml.jackson.core.type.TypeReference;

import io.actor4j.core.utils.GenericType;

public final class TypeReferenceGenerator {
	public static <T> TypeReference<T> generate(GenericType<T> genericType) {
		return new TypeReference<T>() {
			@Override
			public Type getType() { 
				return genericType.getType(); 
			}
		};
	}
}
