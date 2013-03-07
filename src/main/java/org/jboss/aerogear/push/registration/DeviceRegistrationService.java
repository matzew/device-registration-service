/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.aerogear.push.registration;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Named;
import javax.inject.Singleton;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * Simple helper class that stores device tokens and some information about
 * the used mobile Operating System in a database.
 */

@Singleton
@Named("org.jboss.aerogear.DeviceRegistrationService")
public class DeviceRegistrationService {
    
    private MongoClient mc = null;
    private DB database = null;
    
    public DeviceRegistrationService(){
            try {
                mc = new MongoClient();
                database = mc.getDB("test"); // yes... a 'test' instance...
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
    }

    /**
     * Stores the submitted token, OS and its version on a <i>global</i> database. 
     * 
     * @param token device token, submitted by the device
     * @param os Used Operating system
     * @param version version of the mobile OS
     */
    public void registerDevice(String token, String os, String version) {
        DBCollection collection = database.getCollection(os);
        
        // new doc:
        DBObject device = new BasicDBObject(2); // we ignore the version....
        device.put("os", os);
        device.put("token", token);
        
        collection.insert(device);
    }
    
    public Set<String> allTokensForOS(String os) {
        Set<String> tokens = new HashSet<String>();
        DBCollection collection = database.getCollection(os);
        
        // interate:
        DBCursor cursor = collection.find();
        
        try {
            while(cursor.hasNext()) {
                tokens.add((String) cursor.next().get("token"));
            }
        } finally {
            cursor.close();
        }
        return tokens;
    }
}
