package terrorchat;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import java.util.logging.Filter;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.mindrot.jbcrypt.BCrypt;
public class LoginController {
    public LoginController() {
    }
    
    public boolean login(String username, String password){
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<User>users = db.getCollection("user",User.class);
        MongoCollection<LoggedIn> login = db.getCollection("loggedin",LoggedIn.class);
        
        User u = users.find(eq("username",username)).first();
        if(u == null){
            mongoClient.close();
            return false;
        }
        if(BCrypt.checkpw(password, u.getPassword())){
            if(existsInLogin(username)){
                login.updateOne(eq("username",username), set("loggedIn",true));
            }else{
                 login.insertOne(new LoggedIn(username));
            }
            mongoClient.close();
            return true;
        }
        mongoClient.close();
        return false;
    }
    
    public boolean existsInLogin(String username)
    {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<LoggedIn> login = db.getCollection("loggedin",LoggedIn.class);
        
         LoggedIn temp = login.find(eq("username",username)).first();
         if(temp != null)
         {
             if(username.equals(temp.getUsername()))
         {
             mongoClient.close();
             return true;
         }else{
                 mongoClient.close();
             return false;
         }
        }else{
             mongoClient.close();
             return false;
         }
    }
    
    public void logOut(String username)
    {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        
        MongoClient mongoClient = new MongoClient("mcsb08:27017", MongoClientOptions.builder()
                .codecRegistry(pojoCodecRegistry).build());
        
        MongoDatabase db = mongoClient.getDatabase("TerrorChat");
        MongoCollection<LoggedIn> login = db.getCollection("loggedin",LoggedIn.class);
        
        login.updateOne(eq("username",username), set("loggedIn",false));
        mongoClient.close();
    }
}
