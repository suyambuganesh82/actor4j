/*
 * Copyright (c) 2015-2017, David A. Bauer. All rights reserved.
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
package io.actor4j.verification;

import java.util.function.Consumer;

import org.jgrapht.Graph;

import io.actor4j.core.ActorSystem;
import io.actor4j.core.config.ActorSystemConfig;
import io.actor4j.verification.config.ActorVerificationConfig;
import io.actor4j.verification.internal.VerificatorActorSystemImpl;

public class ActorVerificator extends ActorSystem {
	public ActorVerificator() {
		super((wrapper, c) -> new VerificatorActorSystemImpl(wrapper, c), ActorVerificationConfig.create());
	}
	
	@Deprecated
	@Override
	public boolean setConfig(ActorSystemConfig config) {
		return false;
	}
	
	public boolean setConfig(ActorVerificationConfig config) {
		return super.setConfig(config);
	}
	
	public void verify(Consumer<ActorVerificationSM> consumer) {
		((VerificatorActorSystemImpl)system).verify(consumer);
	}
	
	public void verifyAll(Consumer<ActorVerificationSM> consumer, Consumer<Graph<String, ActorVerificationEdge>> consumerAll) {
		((VerificatorActorSystemImpl)system).verifyAll(consumer, consumerAll);
	}
}
