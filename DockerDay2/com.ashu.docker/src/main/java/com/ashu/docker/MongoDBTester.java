package com.ashu.docker;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

public class MongoDBTester {

	public static void main(String[] args) {
		try {
			MongoClient mongoClient = MongoClients
					.create("mongodb://admin:@locpasswordalhost:27017/?authSource=admin&authMechanism=SCRAM-SHA-1");
			MongoDatabase database = mongoClient.getDatabase("user-account");
			MongoCollection<Document> collection = database.getCollection("customers");
			Document document = new Document();
			document.put("name", "ashu tiwary");
			document.put("email", "ashu.tiwary@highradius.com");
			InsertOneResult res = collection.insertOne(document);
			System.out.println(res);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
