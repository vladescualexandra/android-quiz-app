package com.example.quiz_app.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Words {

    private List<Word> words = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Words(){

        try {
            JSONArray jsonArray = new JSONArray("[\n" +
                    "  {\n" +
                    "    \"id\": 0,\n" +
                    "    \"url\": \"@drawable/apple\",\n" +
                    "    \"english\": \"apple\",\n" +
                    "    \"italian\": \"mela\",\n" +
                    "    \"spanish\": \"manzana\",\n" +
                    "    \"french\": \"pomme\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 1,\n" +
                    "    \"url\": \"@drawable/bag\",\n" +
                    "    \"english\": \"bag\",\n" +
                    "    \"italian\": \"sacchetto\",\n" +
                    "    \"spanish\": \"bolso\",\n" +
                    "    \"french\": \"sac\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 2,\n" +
                    "    \"url\": \"@drawable/bathroom\",\n" +
                    "    \"english\": \"bathroom\",\n" +
                    "    \"italian\": \"bagno\",\n" +
                    "    \"spanish\": \"baño\",\n" +
                    "    \"french\": \"salle de bains\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 3,\n" +
                    "    \"url\": \"@drawable/bed\",\n" +
                    "    \"english\": \"bed\",\n" +
                    "    \"italian\": \"letto\",\n" +
                    "    \"spanish\": \"cama\",\n" +
                    "    \"french\": \"lit\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 4,\n" +
                    "    \"url\": \"@drawable/book\",\n" +
                    "    \"english\": \"book\",\n" +
                    "    \"italian\": \"libro\",\n" +
                    "    \"spanish\": \"libro\",\n" +
                    "    \"french\": \"livre\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 5,\n" +
                    "    \"url\": \"@drawable/cake\",\n" +
                    "    \"english\": \"cake\",\n" +
                    "    \"italian\": \"torta\",\n" +
                    "    \"spanish\": \"pastel\",\n" +
                    "    \"french\": \"gâteau\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 6,\n" +
                    "    \"url\": \"@drawable/car\",\n" +
                    "    \"english\": \"car\",\n" +
                    "    \"italian\": \"macchina\",\n" +
                    "    \"spanish\": \"coche\",\n" +
                    "    \"french\": \"voiture\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 7,\n" +
                    "    \"url\": \"@drawable/cat\",\n" +
                    "    \"english\": \"cat\",\n" +
                    "    \"italian\": \"gatto\",\n" +
                    "    \"spanish\": \"gato\",\n" +
                    "    \"french\": \"chat\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 8,\n" +
                    "    \"url\": \"@drawable/chair\",\n" +
                    "    \"english\": \"chair\",\n" +
                    "    \"italian\": \"sedia\",\n" +
                    "    \"spanish\": \"silla\",\n" +
                    "    \"french\": \"chaise\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 9,\n" +
                    "    \"url\": \"@drawable/clock\",\n" +
                    "    \"english\": \"clock\",\n" +
                    "    \"italian\": \"orologio\",\n" +
                    "    \"spanish\": \"reloj\",\n" +
                    "    \"french\": \"l'horloge\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 10,\n" +
                    "    \"url\": \"@drawable/coffee\",\n" +
                    "    \"english\": \"coffee\",\n" +
                    "    \"italian\": \"caffè\",\n" +
                    "    \"spanish\": \"café\",\n" +
                    "    \"french\": \"café\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 11,\n" +
                    "    \"url\": \"@drawable/cookie\",\n" +
                    "    \"english\": \"cookie\",\n" +
                    "    \"italian\": \"biscotto\",\n" +
                    "    \"spanish\": \"galleta\",\n" +
                    "    \"french\": \"biscuit\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 12,\n" +
                    "    \"url\": \"@drawable/dog\",\n" +
                    "    \"english\": \"dog\",\n" +
                    "    \"italian\": \"cane\",\n" +
                    "    \"spanish\": \"perro\",\n" +
                    "    \"french\": \"chien\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 13,\n" +
                    "    \"url\": \"@drawable/fork\",\n" +
                    "    \"english\": \"fork\",\n" +
                    "    \"italian\": \"forchetta\",\n" +
                    "    \"spanish\": \"tenedor\",\n" +
                    "    \"french\": \"fourchette\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 14,\n" +
                    "    \"url\": \"@drawable/green\",\n" +
                    "    \"english\": \"green\",\n" +
                    "    \"italian\": \"verde\",\n" +
                    "    \"spanish\": \"verde\",\n" +
                    "    \"french\": \"vert\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 15,\n" +
                    "    \"url\": \"@drawable/house\",\n" +
                    "    \"english\": \"house\",\n" +
                    "    \"italian\": \"casa\",\n" +
                    "    \"spanish\": \"casa\",\n" +
                    "    \"french\": \"maison\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 16,\n" +
                    "    \"url\": \"@drawable/kitchen\",\n" +
                    "    \"english\": \"kitchen\",\n" +
                    "    \"italian\": \"cucina\",\n" +
                    "    \"spanish\": \"cocina\",\n" +
                    "    \"french\": \"cuisine\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 17,\n" +
                    "    \"url\": \"@drawable/milk\",\n" +
                    "    \"english\": \"milk\",\n" +
                    "    \"italian\": \"latte\",\n" +
                    "    \"spanish\": \"leche\",\n" +
                    "    \"french\": \"lait\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 18,\n" +
                    "    \"url\": \"@drawable/money\",\n" +
                    "    \"english\": \"money\",\n" +
                    "    \"italian\": \"i soldi\",\n" +
                    "    \"spanish\": \"dinero\",\n" +
                    "    \"french\": \"argent\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 19,\n" +
                    "    \"url\": \"@drawable/mug\",\n" +
                    "    \"english\": \"mug\",\n" +
                    "    \"italian\": \"tazza\",\n" +
                    "    \"spanish\": \"jarra\",\n" +
                    "    \"french\": \"agresser\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 20,\n" +
                    "    \"url\": \"@drawable/red\",\n" +
                    "    \"english\": \"red\",\n" +
                    "    \"italian\": \"rosso\",\n" +
                    "    \"spanish\": \"rojo\",\n" +
                    "    \"french\": \"rouge\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 21,\n" +
                    "    \"url\": \"@drawable/shoes\",\n" +
                    "    \"english\": \"shoes\",\n" +
                    "    \"italian\": \"scarpe\",\n" +
                    "    \"spanish\": \"zapatos\",\n" +
                    "    \"french\": \"chaussures\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 22,\n" +
                    "    \"url\": \"@drawable/spoon\",\n" +
                    "    \"english\": \"spoon\",\n" +
                    "    \"italian\": \"cucchiaio\",\n" +
                    "    \"spanish\": \"cuchara\",\n" +
                    "    \"french\": \"cuillère\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 23,\n" +
                    "    \"url\": \"@drawable/tea\",\n" +
                    "    \"english\": \"tea\",\n" +
                    "    \"italian\": \"tè\",\n" +
                    "    \"spanish\": \"té\",\n" +
                    "    \"french\": \"thé\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 24,\n" +
                    "    \"url\": \"@drawable/water\",\n" +
                    "    \"english\": \"water\",\n" +
                    "    \"italian\": \"acqua\",\n" +
                    "    \"spanish\": \"agua\",\n" +
                    "    \"french\": \"eau\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 25,\n" +
                    "    \"url\": \"@drawable/yellow\",\n" +
                    "    \"english\": \"yellow\",\n" +
                    "    \"italian\": \"giallo\",\n" +
                    "    \"spanish\": \"amarillo\",\n" +
                    "    \"french\": \"jaune\"\n" +
                    "  }\n" +
                    "]\n" +
                    "\n" +
                    "\n");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = jsonObject.getInt("id");
                String url = jsonObject.getString("url");
                String english = jsonObject.getString("english");
                String italian = jsonObject.getString("italian");
                String spanish = jsonObject.getString("spanish");
                String french = jsonObject.getString("french");

                Word word = new Word(id, url, english, italian, spanish, french);
                words.add(word);
            }
        } catch (JSONException e) {
            System.out.printf("JSONException: " + e.getMessage());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String readFileAsString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }


    public Word getRandomWord() {
        return null;
    }

    public List<Word> getWords() {
        return words;
    }
}
