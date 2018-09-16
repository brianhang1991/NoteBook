package com.example.demo.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class MongoDBHelp {
    static MongoClient mongoClient;
    private static final String username = "ccyy";
    private static final String database = "ccyy";
    private static final String password = "ccyy";
    //直接登录数据库，无需用户名密码
    public static MongoDatabase getMongoDB(){
        mongoClient = new MongoClient("localhost",27107);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(database);
        return mongoDatabase;
    }
    //验证用户名密码
    public static MongoDatabase getMongoDBwithAuth(){
        ServerAddress address = new ServerAddress("localhost",27107);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(address);
        MongoCredential credential = MongoCredential.createScramSha1Credential(username,database,password.toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);
        MongoDatabase mongoDatabase = null;
        try {
            MongoClient mongoClient = new MongoClient(addrs,credentials);
            mongoDatabase = mongoClient.getDatabase(database);
        }catch (Exception e){
            e.printStackTrace();
        }
        return mongoDatabase;
    }
}
