/*
 *
 * Copyright 2016 Wei-Ming Wu
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package com.github.wnameless.json.flattener;

import java.util.ArrayList;

import org.apache.commons.lang3.text.translate.CharSequenceTranslator;

/**
 * {@link JsonifyArrayList} is simply a ArrayList but with an override jsonify
 * toString method.
 * 
 * @author Wei-Ming Wu
 *
 * @param <E>
 *          the type of elements
 */
public class JsonifyArrayList<E> extends ArrayList<E> {

  private static final long serialVersionUID = -2635637825741772032L;

  private CharSequenceTranslator translator = StringEscapePolicy.NORMAL
      .getCharSequenceTranslator();

  public void setTranslator(CharSequenceTranslator translator) {
    this.translator = translator;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (E e : this) {
      if (e instanceof String) {
        sb.append('"');
        sb.append(translator.translate((String) e));
        sb.append('"');
      } else {
        sb.append(e);
      }
      sb.append(',');
    }
    if (sb.length() > 1) sb.setLength(sb.length() - 1);
    sb.append(']');

    return sb.toString();
  }

}
