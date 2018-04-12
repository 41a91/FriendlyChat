
package terrorchat;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.mindrot.jbcrypt.BCrypt;
import java.util.Date;


public class RegisterController {
    
    
    public static boolean checkIfUserExists(String username)
    {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<User> users = db.getCollection("user",User.class);
        
        Iterator it =  users.find().iterator();
        while(it.hasNext())
        {
          User s = (User)it.next();
          System.out.println("s= "+s.getUsername());
          System.out.println("username in register: "+username);
          
          if(s.getUsername().equals(username))
          {
              mongoClient.close();
              return true;
          }
        }
        mongoClient.close();
        return false;
    }
    
    public static boolean registerUser(String username, String password){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<User> users = db.getCollection("user",User.class);
        
        String encrypted = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(username,encrypted,new Date());
        users.insertOne(user);
        
        mongoClient.close();
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
