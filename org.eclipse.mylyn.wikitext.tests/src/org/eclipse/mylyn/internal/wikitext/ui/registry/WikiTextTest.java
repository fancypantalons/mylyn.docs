/*******************************************************************************
 * Copyright (c) 2007, 2008 David Green and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     David Green - initial API and implementation
 *******************************************************************************/

package org.eclipse.mylyn.internal.wikitext.ui.registry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.mylyn.wikitext.core.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.tests.EclipseRuntimeRequired;
import org.eclipse.mylyn.wikitext.ui.WikiText;
import org.junit.Test;

@EclipseRuntimeRequired
public class WikiTextTest {

	@Test
	public void getFileExtensions() {
		assertTrue(WikiText.getMarkupFileExtensions().contains("textile"));
	}

	@Test
	public void getMarkupLanguage() {
		MarkupLanguage markupLanguage = WikiText.getMarkupLanguage("Textile");
		assertNotNull(markupLanguage);
		assertEquals("Textile", markupLanguage.getName());
	}

	@Test
	public void getMarkupLanguageCopied() {
		MarkupLanguage markupLanguage = WikiText.getMarkupLanguage("Textile");
		assertNotSame(markupLanguage, WikiText.getMarkupLanguage("Textile"));
	}

	@Test
	public void getMarkupLanguageForFilename() {
		MarkupLanguage markupLanguage = WikiText.getMarkupLanguageForFilename("test.textile");
		assertNotNull(markupLanguage);
		assertEquals("Textile", markupLanguage.getName());
	}

	@Test
	public void getMarkupLanguageForFilenameCopied() {
		MarkupLanguage markupLanguage = WikiText.getMarkupLanguageForFilename("test.textile");
		assertNotSame(markupLanguage, WikiText.getMarkupLanguageForFilename("test.textile"));
	}

	@Test
	public void getMarkupLanguageNameForFilename() {
		assertEquals("Textile", WikiText.getMarkupLanguageNameForFilename("test.textile"));
		assertEquals("Textile", WikiText.getMarkupLanguageNameForFilename("test.Textile"));
		assertEquals("Textile", WikiText.getMarkupLanguageNameForFilename("test.textiLe"));
		assertEquals("Textile", WikiText.getMarkupLanguageNameForFilename(".textile"));
		assertNull(WikiText.getMarkupLanguageNameForFilename(".txt"));
	}

	@Test
	public void getMarkupLanguageNames() {
		assertTrue(WikiText.getMarkupLanguageNames().contains("Textile"));
		assertTrue(WikiText.getMarkupLanguageNames().contains("Confluence"));
		assertTrue(WikiText.getMarkupLanguageNames().contains("MediaWiki"));
	}

	@Test
	public void getMarkupValidator() {
		assertNotNull(WikiText.getMarkupValidator("Textile"));
	}
}
