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
package io.actor4j.web.websocket.actors;

import io.actor4j.core.ActorClientRunnable;
import io.actor4j.core.actors.ResourceActor;
import io.actor4j.core.annotations.Stateful;
import io.actor4j.core.immutable.ImmutableList;
import io.actor4j.core.messages.ActorMessage;
import io.actor4j.web.websocket.WebsocketActorClientRunnable;

@Stateful
public class WebsocketResourceActor extends ResourceActor {
	protected final ActorClientRunnable clientRunnable;
	
	public WebsocketResourceActor(String name, boolean bulk, ActorClientRunnable clientRunnable) {
		super(name, bulk);
		this.clientRunnable = clientRunnable;
	}

	public WebsocketResourceActor(String name, ActorClientRunnable clientRunnable) {
		this(name, false, clientRunnable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void receive(ActorMessage<?> message) {
		System.out.println(getName());
		if (message.value!=null) {
			if (message.value instanceof Websocket) {
				Websocket websocket = (Websocket)message.value;
				if (websocket.alias!=null)
					clientRunnable.runViaAlias(message, websocket.alias);
				else if (websocket.node!=null && websocket.path!=null)
					clientRunnable.runViaPath(message, websocket.node, websocket.path);
			}
			/*
			else if (message.value instanceof ImmutableList)
				((WebsocketActorClientRunnable)clientRunnable).runViaAliasAndPath((ImmutableList<ActorMessage<?>>)(message.value));
			*/
			else
				unhandled(message);
		}
		else
			unhandled(message);
	}
}
