package com.example.demo.db;

import com.example.demo.pojo.BookRecord;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoDBCRUD {
    private static final String database = "test";
    public void createCollection(String collectionNmae){
        MongoDatabase mongoDatabase = MongoDBHelp.getMongoDB();
        mongoDatabase.createCollection(collectionNmae);
    }

    public List<BookRecord> searchBookRecords(String key){
        MongoDatabase mongoDatabase = MongoDBHelp.getMongoDB();
        MongoCollection<Document> collection = mongoDatabase.getCollection(database);
        FindIterable<Document> findIterable = collection.find();
        MongoCursor<Document> mongoCursor = findIterable.iterator();
        List<BookRecord> list = new ArrayList<BookRecord>();
        while (mongoCursor.hasNext()){
            Document document = mongoCursor.next();
            BookRecord temp = new BookRecord();
            temp.setName(document.get("name").toString());
            temp.setAuthor(document.get("author").toString());
            list.add(temp);
        }
        return list;
    }
}
