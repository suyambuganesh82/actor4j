/*
 * Copyright (c) 2015-2018, David A. Bauer. All rights reserved.
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
package io.actor4j.web.mqtt;

import java.util.Arrays;

import io.actor4j.core.utils.Shareable;

public class MQTTPublish implements Shareable {
	public final String topic;
	public final byte[] payload;
	public final int qos; 
	public final boolean retained;
	
	public MQTTPublish(String topic, byte[] payload, int qos, boolean retained) {
		super();
		this.topic = topic;
		this.payload = payload;
		this.qos = qos;
		this.retained = retained;
	}

	@Override
	public String toString() {
		return "MQTTPublish [topic=" + topic + ", payload=" + Arrays.toString(payload) + ", qos=" + qos + ", retained="
				+ retained + "]";
	}
}
