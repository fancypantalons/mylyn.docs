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

package org.eclipse.mylyn.wikitext.html.core;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import java.util.Set;

import org.eclipse.mylyn.internal.wikitext.html.core.HtmlSubsetLanguage;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder.BlockType;
import org.eclipse.mylyn.wikitext.core.parser.DocumentBuilder.SpanType;
import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

/**
 * Provides a way to build HTML languages that support a specific set of HTML tags.
 * 
 * @author david.green
 * @see HtmlLanguage#builder()
 * @since 2.0
 */
public class HtmlLanguageBuilder {
	private String name;

	private final Set<BlockType> blockTypes = Sets.newHashSet();

	private final Set<SpanType> spanTypes = Sets.newHashSet();

	HtmlLanguageBuilder() {
		// prevent direct instantiation
	}

	/**
	 * Sets the {@link MarkupLanguage#getName() name} of the markup language.
	 * 
	 * @param name
	 *            the name
	 * @return this builder
	 */
	public HtmlLanguageBuilder name(String name) {
		checkNotNull(name, "Must provide a name"); //$NON-NLS-1$
		checkArgument(!Strings.isNullOrEmpty(name), "Name must not be empty"); //$NON-NLS-1$
		checkArgument(!name.equalsIgnoreCase(HtmlLanguage.NAME_HTML), "Name must not be equal to %s", //$NON-NLS-1$
				HtmlLanguage.NAME_HTML);
		checkArgument(name.equals(name.trim()), "Name must not have leading or trailing whitespace"); //$NON-NLS-1$
		this.name = name;
		return this;
	}

	/**
	 * Adds the given {@link BlockType} to the supported syntax of the language created by this builder.
	 * 
	 * @param blockType
	 *            the block type
	 * @return this builder
	 */
	public HtmlLanguageBuilder add(BlockType blockType) {
		blockTypes.add(checkNotNull(blockType, "Must provide a blockType")); //$NON-NLS-1$
		return this;
	}

	/**
	 * Adds the given {@link SpanType} to the supported syntax of the language created by this builder.
	 * 
	 * @param spanType
	 *            the span type
	 * @return this builder
	 */
	public HtmlLanguageBuilder add(SpanType spanType) {
		spanTypes.add(checkNotNull(spanType, "Must provide a spanType")); //$NON-NLS-1$
		return this;
	}

	public HtmlLanguage create() {
		checkState(name != null, "Name must be provided to create an HtmlLanguage"); //$NON-NLS-1$
		checkState(!blockTypes.isEmpty(), "Must provide support for at least one block type"); //$NON-NLS-1$

		return new HtmlSubsetLanguage(name, blockTypes, spanTypes);
	}
}
