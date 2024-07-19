package com.codurance.infrastructure.persistence;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDatabaseManager {
    private static MongoClient mongoClient;

    public static synchronized MongoClient getMongoClient(String connectionString) {
        if (mongoClient == null) {
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(new ConnectionString(connectionString)).build();

            mongoClient = MongoClients.create(mongoClientSettings);
        }

        return mongoClient;
    }
}
