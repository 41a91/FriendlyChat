/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terrorchat;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

public class SendMessageController {
    
    public static void insertMessage(String[] to, String from, String subject, String body){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Message> messages = db.getCollection("message",Message.class);
        
        ArrayList<Message> messageToSend = new ArrayList<>();
        
        for(String user : to)
        {
            if(RegisterController.checkIfUserExists(user))
            {
                 messageToSend.add(new Message(user,from,subject,body,new Date().getTime(),false));
            }
        }
        
        System.out.println("Message to send: "+messageToSend);
        
        messages.insertMany(messageToSend);
        
        mongoClient.close();  
    }
    
    public static HashMap<String,Draft> getDrafts(String username){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        
        MongoCollection<Draft> drafts = db.getCollection("draft",Draft.class);
        
        Iterator it = drafts.find(Filters.eq("fromUsername", username)).iterator();
        mongoClient.close();
        
        HashMap<String,Draft> map = new HashMap<>();
        
        while(it.hasNext())
        {
            Draft temp = (Draft)it.next();
            map.put(temp.getSubject(), temp);
        }
        
        
        
        
        return map;
        
    }
    
    public static void insertDrafts(String to, String from, String subject, String body){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Draft> drafts = db.getCollection("draft",Draft.class);
        Draft temp = new Draft(to,from,subject,body,new Date().getTime());
        drafts.insertOne(temp);
        
        mongoClient.close();  
    }
    
    public static void deleteDraft(String subject){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Draft> drafts = db.getCollection("draft",Draft.class);
        
        drafts.deleteOne(Filters.eq("subject", subject));
        
        mongoClient.close();  
    }
    
    
    
    
    
}
