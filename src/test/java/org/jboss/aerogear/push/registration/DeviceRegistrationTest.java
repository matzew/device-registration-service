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

import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

public class DeviceRegistrationTest {

    
    @Test
    public void storeDevice() {
        //@Inject
        DeviceRegistrationService ds = new DeviceRegistrationService();
        
        ds.registerDevice("9ecda1fe6d7e135cd97485a395338c1a9f4de5ee5f5fe2847d8161398e978d10", "iOS", "6.1");
        ds.registerDevice("APA91bHVDj-EA1GZxmR8GYtxtMfDX6RsC54PpQjbC28-WwDnesns9nY28g51HBxzrELdlO9XHfyxfI31wc6O0aZ4K5P7gbuv2VhVowa_BPBra4TGeKkYjlI0c8M5Y0sMyYiHqIkJFUBqQXPz8QSCBylDePBCNViCog", "android", "4");
    }

    @Test
    public void queryAndroid() {
        //@Inject
        DeviceRegistrationService ds = new DeviceRegistrationService();
        Set<String> androidTokens = ds.allTokensForOS("android");

        Assert.assertNotNull(androidTokens);
        System.out.println(androidTokens);
    }

    @Test
    public void query_iOS() {
        //@Inject
        DeviceRegistrationService ds = new DeviceRegistrationService();
        Set<String> iOSTokens = ds.allTokensForOS("iOS");

        Assert.assertNotNull(iOSTokens);
        System.out.println(iOSTokens);
    }
}
