package me.xplore.engineering_excercise.db;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import me.xplore.engineering_excercise.types.WheelItem;
import org.bson.Document;

import java.util.ArrayList;

public class MongoInteraction {
    private static boolean is_init = false;

    private static MongoClient client;
    private static MongoDatabase items_db;
    private static MongoCollection items_collection;
    public static void init() {
        if(is_init) return;
        MongoClientURI connectionString = new MongoClientURI("no uri for u hehe");
        client = new MongoClient(connectionString);
        items_db = client.getDatabase("casino_wheel");
        items_collection = items_db.getCollection("wheel_items");
        is_init = true;
    }

    public static ArrayList<WheelItem> getWheelItems() {
        if(!is_init) init();

        ArrayList<WheelItem> list = new ArrayList<WheelItem>();

        FindIterable<Document> iterDoc = items_collection.find();
        for (Document document : iterDoc) {
            String val = document.getString("game_value_id");
            int chance = document.getInteger("chance", 1);

            list.add(new WheelItem(val, chance));
        }

        return list;
    }

    public static void writeItem(WheelItem item) {
        Document document = new Document();
        document.append("game_value_id", item.item_val);
        document.append("chance", item.chance);
        items_collection.insertOne(document);
    }
}
