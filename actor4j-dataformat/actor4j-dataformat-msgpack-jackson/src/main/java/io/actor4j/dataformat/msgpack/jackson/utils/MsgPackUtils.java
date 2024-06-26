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
package io.actor4j.dataformat.msgpack.jackson.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.actor4j.core.utils.GenericType;
import io.actor4j.dataformat.msgpack.jackson.ObjectMapperImpl;
import io.actor4j.dataformat.msgpack.jackson.TypeReferenceGenerator;

public final class MsgPackUtils {
	public static byte[] encode(Object obj) {
		byte[] result = null;
		
		try {
			result = ObjectMapperImpl.underlyingImpl().writeValueAsBytes(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static <T> T decode(byte[] src, Class<T> type) {
		T result = null;
		
		try {
			result = ObjectMapperImpl.underlyingImpl().readValue(src, type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static <T> T decode(byte[] src, GenericType<T> type) {
		T result = null;
		
		try {
			result = ObjectMapperImpl.underlyingImpl().readValue(src, TypeReferenceGenerator.generate(type));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
