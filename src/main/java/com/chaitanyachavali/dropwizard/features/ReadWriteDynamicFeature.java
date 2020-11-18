/*
 * Copyright 2020 chaitanyachavali <chavalichaithanyachinna@gmail.com>.
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
package com.chaitanyachavali.dropwizard.features;

import com.chaitanyachavali.dropwizard.annotations.ReadOnlyAPI;
import com.chaitanyachavali.dropwizard.enums.FilterMode;
import com.chaitanyachavali.dropwizard.filters.ReadWriteResourcesFilter;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

public class ReadWriteDynamicFeature implements DynamicFeature {

  private final FilterMode mode;

  public ReadWriteDynamicFeature(FilterMode mode) {
    this.mode = mode;
  }

  public void configure(ResourceInfo resourceInfo, FeatureContext context) {
    if (!resourceInfo.getResourceMethod().isAnnotationPresent(ReadOnlyAPI.class)) {
      context.register(new ReadWriteResourcesFilter(this.mode));
    }
  }
}
