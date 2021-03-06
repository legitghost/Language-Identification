/* LanguageTool, a natural language style checker 
 * Copyright (C) 2005 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package de.danielnaber.languagetool.dev.index;

import java.io.StringReader;

import junit.framework.TestCase;

import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

public class AnyCharTokenizerTest extends TestCase {

  public void testAnyCharTokenizer() throws Exception {
    StringReader sr = new StringReader("It's a good day, I liked it!");

    AnyCharTokenizer tokenizer = new AnyCharTokenizer(Version.LUCENE_31, sr);
    CharTermAttribute termAtt = tokenizer.addAttribute(CharTermAttribute.class);

    assertTrue(tokenizer.incrementToken());
    // AnyCharTokenizer emits the entire input (i.e. a sentence) as a single token
    assertEquals("It's a good day, I liked it!", termAtt.toString());

    // it emits only one token.
    assertFalse(tokenizer.incrementToken());

  }
}
