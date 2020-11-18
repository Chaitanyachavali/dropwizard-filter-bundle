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
package com.chaitanyachavali.dropwizard.filters;

import com.chaitanyachavali.dropwizard.enums.FilterMode;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class ReadWriteResourcesFilter implements ContainerRequestFilter {

  public final FilterMode mode;

  public ReadWriteResourcesFilter(FilterMode mode) {
    this.mode = mode;
  }

  public void filter(ContainerRequestContext requestContext) {
    if (FilterMode.READ_ONLY.equals(mode)
        && !HttpMethod.GET.equalsIgnoreCase(requestContext.getMethod())) {
      requestContext.abortWith(Response
          .status(Status.SERVICE_UNAVAILABLE)
          .entity("Currently not accepting requests for this resource")
          .build());
    }
  }
}
