/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.rest.util;

import org.eclipse.hawkbit.exception.AbstractServerRtException;
import org.eclipse.hawkbit.exception.SpServerError;

/**
 * Thrown if artifact content streaming to client failed.
 */
public final class FileSteamingFailedException extends AbstractServerRtException {

    private static final long serialVersionUID = 1L;

    /**
     * Creates a new FileUploadFailedException with
     * {@link SpServerError#SP_REST_BODY_NOT_READABLE} error.
     */
    public FileSteamingFailedException() {
        super(SpServerError.SP_ARTIFACT_LOAD_FAILED);
    }

    /**
     * Constructor with Throwable.
     * 
     * @param cause
     *            for the exception
     */
    public FileSteamingFailedException(final Throwable cause) {
        super(SpServerError.SP_ARTIFACT_LOAD_FAILED, cause);
    }

    /**
     * Constructor with error string.
     * 
     * @param message
     *            of the error
     */
    public FileSteamingFailedException(final String message) {
        super(message, SpServerError.SP_ARTIFACT_LOAD_FAILED);
    }
}
