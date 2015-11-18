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
package inf4375.model;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * A Business representation of an Album.
 */
public class CatFact {

    private String fact;

    public CatFact(String fact) {
        this.fact = fact;
    }

    // Build self from a JsonObject.
    public CatFact(JsonObject obj) {
        this.fact = (obj.getJsonArray("facts").getString(0));
    }

    // Translate `self` as a JsonObject.
    public JsonObject toJson() {
        JsonObjectBuilder obj = Json.createObjectBuilder();
        obj.add("fact", fact);
        return obj.build();
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
