package inf4375.server.controllers;

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
import inf4375.model.CatFact;
import inf4375.model.Catalog;
import inf4375.server.Request;
import inf4375.server.Router;
import inf4375.server.UriMatchController;
import inf4375.server.views.html.HTMLFact;
import inf4375.server.views.html.HTMLFactPart;
import inf4375.server.views.html.HTMLFactsList;

/**
 * A Controller that displays the catalog in JSON format.
 */
public class HTMLFactsController extends UriMatchController {

    // Data Access Object to album list.
    Catalog catalog;

    public HTMLFactsController(Catalog catalog) {
        this.uriMatch = "^/facts(/?|/.*)";
        this.catalog = catalog;
    }

    @Override
    public void action(Router router, Request request) {
        switch(request.uri) {
            case "/facts/":
            case "/facts":
                actionShowFact(router, request);
                return;
            case "/facts/fragment":
            case "/facts/fragment/":
                actionShowFragment(router, request);
                return;
            case "/facts/list":
            case "/facts/list/":
                actionShowList(router, request);
                return;
        }
    }

    public void actionShowFact(Router router, Request request) {
        Integer id = (int) (Math.random() * 100);
        CatFact fact = catalog.findCatFact(id);
        if (fact == null) {
            router.sendJsonError(404, "Not found");
            return;
        }
        HTMLFact view = new HTMLFact("CatFact", fact);
        router.sendResponse(200, "OK", view);
    }

    public void actionShowFragment(Router router, Request request) {
        Integer id = (int) (Math.random() * 100);
        CatFact fact = catalog.findCatFact(id);
        if (fact == null) {
            router.sendJsonError(404, "Not found");
            return;
        }
        HTMLFactPart view = new HTMLFactPart("CatFact", fact);
        router.sendResponse(200, "OK", view);
    }

    public void actionShowList(Router router, Request request) {
        HTMLFactsList view = new HTMLFactsList("CatFacts");
        router.sendResponse(200, "OK", view);
    }
}
