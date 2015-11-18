/*
 * Copyright 2015 Alexandre Terrasa <alexandre@moz-code.org>.
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
package inf4375.server.views.html;

import inf4375.model.CatFact;
import inf4375.server.HTMLView;

/**
 * A view that displays a fact in HTML format.
 */
public class HTMLFactPart extends HTMLView {

    CatFact fact;

    public HTMLFactPart(String viewTitle, CatFact fact) {
        super(viewTitle);
        this.fact = fact;
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append("<p>");
        builder.append(fact.getFact());
        builder.append("</p>");
        return builder.toString();
    }
}
