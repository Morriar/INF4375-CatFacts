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
package inf4375.server.controllers;

import inf4375.model.CatFact;
import inf4375.model.Catalog;
import inf4375.server.Request;
import inf4375.server.Router;
import inf4375.server.UriMatchController;

/**
 * A Controller that displays the catalog in JSON format.
 */
public class FactsController extends UriMatchController {

    Catalog catalog;

    public FactsController(Catalog catalog) {
        this.uriMatch = "^/json/facts/?$";
        this.catalog = catalog;
    }

    @Override
    public void action(Router router, Request request) {
        switch (request.method) {
            case "GET":
                actionGetFact(router, request);
                return;
        }
        router.sendJsonError(400, "Bad request");
    }

    // Returns the JSON Object representing the album having `id`.
    private void actionGetFact(Router router, Request request) {
        Integer id = (int) (Math.random() * 100);
        CatFact fact = catalog.findCatFact(id);
        if (fact == null) {
            router.sendJsonError(404, "Not found");
            return;
        }
        router.sendJsonResponse(200, "OK", fact.toJson());
    }
}
