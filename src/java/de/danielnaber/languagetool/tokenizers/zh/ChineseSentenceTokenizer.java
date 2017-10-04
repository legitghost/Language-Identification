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
package de.danielnaber.languagetool.tokenizers.zh;

import java.util.ArrayList;
import java.util.List;

import org.ictclas4j.bean.Sentence;
import org.ictclas4j.segment.SentenceSeg;
import org.ictclas4j.utility.Utility;

import de.danielnaber.languagetool.tokenizers.SentenceTokenizer;

public class ChineseSentenceTokenizer extends SentenceTokenizer {

  @Override
  public List<String> tokenize(String text) {

    final SentenceSeg ss = new SentenceSeg(text);
    final ArrayList<Sentence> sens = ss.getSens();
    final ArrayList<String> list = new ArrayList<String>();

    for (Sentence sen : sens) {
      String str = sen.getContent();
      if (str.contains(Utility.SENTENCE_BEGIN)) {
        str = str.substring(Utility.SENTENCE_BEGIN.length());
      }
      if (str.contains(Utility.SENTENCE_END)) {
        str = str.substring(0, str.length() - Utility.SENTENCE_BEGIN.length());
      }
      list.add(str);
    }
    return list;
  }
}