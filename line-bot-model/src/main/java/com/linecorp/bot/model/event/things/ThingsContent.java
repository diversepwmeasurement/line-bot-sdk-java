/*
 * Copyright 2023 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.bot.model.event.things;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonSubTypes({
        @JsonSubTypes.Type(LinkThingsContent.class),
        @JsonSubTypes.Type(UnlinkThingsContent.class),
        @JsonSubTypes.Type(ScenarioResultThingsContent.class),
})
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        defaultImpl = UnknownLineThingsContent.class,
        visible = true
)
public interface ThingsContent {
    /**
     * The id that LINE Things issues.
     */
    String getDeviceId();
}
