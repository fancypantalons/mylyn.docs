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

package org.eclipse.mylyn.internal.wikitext.markdown.tests;

import org.eclipse.mylyn.wikitext.markdown.core.MarkdownLanguage;
import org.eclipse.mylyn.wikitext.tests.AbstractMarkupGenerationTest;
import org.junit.Test;

public class MarkdownHeadingTest extends AbstractMarkupGenerationTest<MarkdownLanguage> {

	@Test
	public void underlinedHeadingsHaveIds() {
		assertMarkup("<h1 id=\"Heading1\">Heading 1</h1><p>some content</p><h1 id=\"Heading2\">Heading 2</h1>",//
				"" + //	
						"Heading 1\n" + //
						"=========\n" + "\n" + //
						"some content\n\n" + //
						"Heading 2\n" + //
						"===========");
	}

	@Test
	public void headingsHaveIds() {
		assertMarkup("<h1 id=\"Heading1\">Heading 1</h1><p>content</p><h1 id=\"Heading2\">Heading 2</h1>",
				"# Heading 1\n\ncontent\n\n# Heading 2");
	}

	/*
	 * Headers. Atx-style headers use 1-6 hash characters at the start of the line, corresponding to header levels 1-6.
	 */
	@Test
	public void testAtxStyleHeaderH1() {
		assertMarkup("<h1 id=\"ThisisanH1\">This is an H1</h1>", "# This is an H1");
	}

	@Test
	public void testAtxStyleHeaderH2() {
		assertMarkup("<h2 id=\"ThisisanH2\">This is an H2</h2>", "## This is an H2");
	}

	@Test
	public void testAtxStyleHeaderH3() {
		assertMarkup("<h3 id=\"ThisisanH3\">This is an H3</h3>", "### This is an H3");
	}

	@Test
	public void testAtxStyleHeaderH4() {
		assertMarkup("<h4 id=\"ThisisanH4\">This is an H4</h4>", "#### This is an H4");
	}

	@Test
	public void testAtxStyleHeaderH5() {
		assertMarkup("<h5 id=\"ThisisanH5\">This is an H5</h5>", "##### This is an H5");
	}

	@Test
	public void testAtxStyleHeaderH6() {
		assertMarkup("<h6 id=\"ThisisanH6\">This is an H6</h6>", "###### This is an H6");
	}

	/*
	 * Optionally, you may "close" atx-style headers. This is purely cosmetic - you can use this if you think it looks
	 * better. The closing hashes don't even need to match the number of hashes used to open the header. (The number of
	 * opening hashes determines the header level.)
	 */
	@Test
	public void testClosedAtxStyleHeaderH1() {
		assertMarkup("<h1 id=\"ThisisanH1\">This is an H1</h1>", "# This is an H1 #");
	}

	@Test
	public void testClosedAtxStyleHeaderH2() {
		assertMarkup("<h2 id=\"ThisisanH2\">This is an H2</h2>", "## This is an H2 ##");
	}

	@Test
	public void testClosedAtxStyleHeaderH3() {
		assertMarkup("<h3 id=\"ThisisanH3\">This is an H3</h3>", "### This is an H3 ###");
	}

	@Test
	public void testClosedAtxStyleHeaderH4() {
		assertMarkup("<h4 id=\"ThisisanH4\">This is an H4</h4>", "#### This is an H4 ####");
	}

	@Test
	public void testClosedAtxStyleHeaderH5() {
		assertMarkup("<h5 id=\"ThisisanH5\">This is an H5</h5>", "##### This is an H5 #####");
	}

	@Test
	public void testClosedAtxStyleHeaderH6() {
		assertMarkup("<h6 id=\"ThisisanH6\">This is an H6</h6>", "###### This is an H6 ######");
	}

	@Test
	public void testClosedAtxStyleHeaderWithMoreClosingHashes() {
		assertMarkup("<h1 id=\"ThisisanH1\">This is an H1</h1>", "# This is an H1 ################################");
	}

	@Test
	public void testClosedAtxStyleHeaderWithLessCosingHashes() {
		assertMarkup("<h6 id=\"ThisisanH6\">This is an H6</h6>", "###### This is an H6 #");
	}

	/*
	 * Setext-style headers are "underlined" using equal signs (for first-level headers) and dashes (for second-level
	 * headers). Any number of underlining ='s or -'s will work.
	 */
	@Test
	public void testUnderlinedHeaderH1() {
		assertMarkup("<h1 id=\"ThisisanH1\">This is an H1</h1>", "This is an H1\n============");
	}

	@Test
	public void testUnderlinedHeaderH2() {
		assertMarkup("<h2 id=\"ThisisanH2\">This is an H2</h2>", "This is an H2\n------------");
	}

	@Test
	public void testSingleCharUnderlinedHeaderH1() {
		assertMarkup("<h1 id=\"ThisisanH1\">This is an H1</h1>", "This is an H1\n= ");
	}

	@Test
	public void testSingleCharUnderlinedHeaderH2() {
		assertMarkup("<h2 id=\"ThisisanH2\">This is an H2</h2>", "This is an H2\n- ");
	}

	@Override
	protected MarkdownLanguage createMarkupLanguage() {
		return new MarkdownLanguage();
	}

}
