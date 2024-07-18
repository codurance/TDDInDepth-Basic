package com.codurance.infrastructure.persistence;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDatabaseManager {
    private static MongoClient mongoClient;

    public static synchronized MongoClient getMongoClient() {
        if (mongoClient == null) {
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(new ConnectionString("mongodb://localhost:27017")).build();

            mongoClient = MongoClients.create(mongoClientSettings);
        }

        return mongoClient;
    }
}
