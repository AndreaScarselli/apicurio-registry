/*
 * Copyright 2021 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.rest.client.exception;


import io.apicurio.registry.rest.v2.beans.Error;
import io.apicurio.rest.client.error.ApicurioRestClientException;

/**
 * @author Carles Arnal 'carles.arnal@redhat.com'
 */
public class RestClientException extends ApicurioRestClientException {

    private static final long serialVersionUID = 1L;

    private final Error error;

    public RestClientException(Error error) {
        super(error.getMessage());
        this.error = error;
    }
    
    public RestClientException(Throwable cause) {
        super(cause);
        this.error = Error.builder().message(cause.getMessage()).name(cause.getClass().getSimpleName()).build();
    }

    public Error getError() {
        return error;
    }
}
