/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.core.protocol.json;

import software.amazon.awssdk.annotations.SdkProtectedApi;
import software.amazon.awssdk.core.runtime.http.response.JsonResponseHandler;
import software.amazon.awssdk.core.runtime.transform.JsonUnmarshallerContext;
import software.amazon.awssdk.core.runtime.transform.Unmarshaller;

/**
 * Common interface for creating generators (writers) and protocol handlers for JSON like protocols.
 */
@SdkProtectedApi
public interface StructuredJsonFactory {

    /**
     * Returns the {@link StructuredJsonGenerator} to be used for marshalling the request.
     *
     * @param contentType Content type to send for requests.
     */
    StructuredJsonGenerator createWriter(String contentType);

    /**
     * Returns the response handler to be used for handling a successful response.
     *
     * @param operationMetadata Additional context information about an operation to create the
     * appropriate response handler.
     */
    <T> JsonResponseHandler<T> createResponseHandler(
        JsonOperationMetadata operationMetadata,
        Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller);
}
