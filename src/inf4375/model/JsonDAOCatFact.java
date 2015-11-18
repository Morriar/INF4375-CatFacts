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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonReader;

/**
 * An implementation of a DAOCatFact using JSON files.
 */
public class JsonDAOCatFact implements DAOCatFact {

    String factsDir = "json/";

    @Override
    public CatFact findFact(Integer id) {
        File jsonFile = new File("json/catfact." + id + ".json");
        try (FileInputStream inputStream = new FileInputStream(jsonFile)) {
            try (JsonReader reader = Json.createReader(inputStream)) {
                return new CatFact(reader.readObject());
            }
        } catch (IOException ex) {
            System.err.println("Warning: unable to find file at " + jsonFile);
            return null;
        }

    }
}
