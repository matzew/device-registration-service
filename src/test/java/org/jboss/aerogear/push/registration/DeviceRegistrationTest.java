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
        
        ds.registerDevice("0-91238t47eruwoia;lkde20-1830-9qweopq243-09", "iOS", "6.1");
        ds.registerDevice("BPBra4TGeKkYjlI0c8M5Y0sM0-91238t47eruwoia;lkde20yYiHqIkJFUBqQXPz8QSCBylDePBCNViCog", "android", "4");
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
