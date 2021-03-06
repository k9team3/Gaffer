/*
 * Copyright 2016 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gaffer.store.operation.handler.export;

import gaffer.export.Exporter;
import gaffer.operation.OperationException;
import gaffer.operation.impl.export.initialise.InitialiseExport;
import gaffer.store.Context;
import gaffer.store.Store;
import gaffer.store.operation.handler.OperationHandler;

public class InitialiseExportHandler implements OperationHandler<InitialiseExport, Object> {
    @Override
    public Object doOperation(final InitialiseExport operation,
                              final Context context, final Store store)
            throws OperationException {
        final Exporter exporter = operation.getExporter();
        exporter.initialise(operation.getKey(), store, context.getUser());
        context.addExporter(exporter);
        return operation.getInput();
    }
}
