/*******************************************************************************
 * Copyright (c) 2013 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.wikitext.core.parser.builder.event;

import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder;

import com.google.common.base.Objects;

/**
 * An {@link DocumentBuilderEvent} corresponding to {@link DocumentBuilder#endDocument()}.
 * 
 * @author david.green
 * @since 2.0
 */
public class EndDocumentEvent extends DocumentBuilderEvent {
	@Override
	public void invoke(DocumentBuilder builder) {
		builder.endDocument();
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(EndDocumentEvent.class);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof EndDocumentEvent)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "endDocument()"; //$NON-NLS-1$
	}
}
