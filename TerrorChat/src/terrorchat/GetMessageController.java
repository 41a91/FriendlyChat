
package terrorchat;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.bson.Document;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class GetMessageController {
    public ArrayList<Message> getAllUnreadMessages(String username){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Message>messages = db.getCollection("message",Message.class);
        ArrayList<Message>unreadMessages = new ArrayList<>();
        
        //Need to ad a filter for each user 
        
        System.out.println(username);
        
        FindIterable<Message> message = messages.find(and(eq("read",false),eq("toUsername",username)));
        Iterator it = message.iterator();
        while(it.hasNext()){
            unreadMessages.add((Message)it.next());
        }
        mongoClient.close();
        return unreadMessages;
    }
    
    public boolean updateMessageToRead(Message message  , String username){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Message>messages = db.getCollection("message",Message.class);
       
        
        //Need to ad a filter for each user 
        String body = message.getBody();
        String fromUsername = message.getFromUsername();
        String subject = message.getSubject();
        
        Document d = new Document().append("body",body)
                                        .append("toUsername", username)
                                        .append("fromUsername", fromUsername)
                                        .append("subject", subject);
        
        messages.updateOne(d, set("read",true));
        mongoClient.close();
        return true;
    }
    
    public ArrayList<Message> getAllFromSpecifiedUser(String fromUsername, String toUsername){
         CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Message>messages = db.getCollection("message",Message.class);
        ArrayList<Message>userMessages = new ArrayList<>();
        FindIterable<Message> message = messages.find(and(eq("fromUsername",fromUsername),eq("toUsername",toUsername)));
        Iterator it = message.iterator();
        while(it.hasNext()){
            userMessages.add((Message)it.next());
        }
        mongoClient.close();
        return userMessages;
    }
    
    public ArrayList<Message>getMessageBySearchedTerm(String term, String username){
       CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        Pattern pattern = Pattern.compile(term,Pattern.CASE_INSENSITIVE);
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Message>messages = db.getCollection("message",Message.class);
        Document q = new Document().append("body",pattern)
                                        .append("toUsername", username);
        
        ArrayList<Message>termMessages = new ArrayList<>();
        FindIterable<Message> message = messages.find(q);
        Iterator it = message.iterator();
        while(it.hasNext()){
            termMessages.add((Message)it.next());
        }
        mongoClient.close();
        return termMessages;
    }
    
    public ArrayList<Message>getAllMessages(String username){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Message>messages = db.getCollection("message",Message.class);
        ArrayList<Message>userMessages = new ArrayList<>();
        FindIterable<Message> message = messages.find(eq("toUsername",username));
        Iterator it = message.iterator();
        while(it.hasNext()){
            userMessages.add((Message)it.next());
        }
        mongoClient.close();
        return userMessages;
    }
    
    public ArrayList<Message>getAllSentMessages(String username){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<Message>messages = db.getCollection("message",Message.class);
        ArrayList<Message>unreadMessages = new ArrayList<>();
        
        //Need to ad a filter for each user 
        
        FindIterable<Message> message = messages.find(eq("fromUsername",username));
        Iterator it = message.iterator();
        while(it.hasNext()){
            unreadMessages.add((Message)it.next());
        }
        mongoClient.close();
        return unreadMessages;
    }
    
    
    
    
}
