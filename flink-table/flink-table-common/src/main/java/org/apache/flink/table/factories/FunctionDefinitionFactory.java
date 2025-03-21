/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.factories;

import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.table.catalog.CatalogFunction;
import org.apache.flink.table.functions.FunctionDefinition;

/** A factory to create {@link FunctionDefinition}. */
@PublicEvolving
public interface FunctionDefinitionFactory {

    /**
     * Creates a {@link FunctionDefinition} from given {@link CatalogFunction} with the given {@link
     * Context} containing the class loader of the current session, which is useful when it's needed
     * to load class from class name.
     *
     * @param name name of the {@link CatalogFunction}
     * @param catalogFunction the catalog function
     * @param context the {@link Context} for creating function definition
     * @return a {@link FunctionDefinition}
     */
    FunctionDefinition createFunctionDefinition(
            String name, CatalogFunction catalogFunction, Context context);

    /** Context provided when a function definition is created. */
    @PublicEvolving
    interface Context {
        /** Returns the class loader of the current session. */
        ClassLoader getClassLoader();
    }
}
