/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mubaloo.org.chart.http.test;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import com.mubaloo.org.test.activity.MubalooTestActivity;
import com.mubaloo.proxy.cache.HTTPProxyRequest;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

/**
 * <p>
 * Test HTTP GET request
 * </p>
 *
 * @author Zahid
 */
public class TestHTTPProxyRequest extends ActivityInstrumentationTestCase2<MubalooTestActivity> {

    /*
    * Android activity
    */
    private Activity activity;

    public TestHTTPProxyRequest() {
        super("com.mubaloo.org.test.activity", MubalooTestActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp(); //To change body of generated methods, choose Tools | Templates.

        activity = this.getActivity();

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown(); //To change body of generated methods, choose Tools | Templates.
    }

    @Test
    public void testHTTPGet() throws Exception {
        String res = "[\n"
                + "	{\n"
                + "		\"id\" : \"001\",\n"
                + "		\"firstName\" : \"Mark\",\n"
                + "		\"lastName\" : \"Mason\",\n"
                + "		\"role\" : \"CEO\",\n"
                + "		\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "	},\n"
                + "	{\n"
                + "		\"teamName\" : \"iOS\",\n"
                + "		\"members\" : [\n"
                + "			{\n"
                + "				\"id\" : \"002\",\n"
                + "				\"firstName\" : \"Olly\",\n"
                + "				\"lastName\" : \"Berry\",\n"
                + "				\"role\" : \"iOS Team Lead\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\",\n"
                + "				\"teamLead\" : true\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"003\",\n"
                + "				\"firstName\" : \"James\",\n"
                + "				\"lastName\" : \"Frost\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"004\",\n"
                + "				\"firstName\" : \"Liam\",\n"
                + "				\"lastName\" : \"Nichols\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"005\",\n"
                + "				\"firstName\" : \"Chris\",\n"
                + "				\"lastName\" : \"Watson\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"006\",\n"
                + "				\"firstName\" : \"Richard\",\n"
                + "				\"lastName\" : \"Turton\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"007\",\n"
                + "				\"firstName\" : \"Matt\",\n"
                + "				\"lastName\" : \"Colliss\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"008\",\n"
                + "				\"firstName\" : \"David\",\n"
                + "				\"lastName\" : \"Gibson\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"009\",\n"
                + "				\"firstName\" : \"Tom\",\n"
                + "				\"lastName\" : \"Guy\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"010\",\n"
                + "				\"firstName\" : \"Rich\",\n"
                + "				\"lastName\" : \"Hodgkins\",\n"
                + "				\"role\" : \"iOS Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			}\n"
                + "		]\n"
                + "	},\n"
                + "	{\n"
                + "		\"teamName\" : \"Android\",\n"
                + "		\"members\" : [{\n"
                + "				\"id\" : \"011\",\n"
                + "				\"firstName\" : \"David\",\n"
                + "				\"lastName\" : \"Branton\",\n"
                + "				\"role\" : \"Android Team Lead\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\",\n"
                + "				\"teamLead\" : true\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"012\",\n"
                + "				\"firstName\" : \"Dre\",\n"
                + "				\"lastName\" : \"Pilipczuk\",\n"
                + "				\"role\" : \"Android Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"013\",\n"
                + "				\"firstName\" : \"Ray\",\n"
                + "				\"lastName\" : \"Britton\",\n"
                + "				\"role\" : \"Android Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"014\",\n"
                + "				\"firstName\" : \"Charly\",\n"
                + "				\"lastName\" : \"Murillo\",\n"
                + "				\"role\" : \"Android Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			}\n"
                + "		]	\n"
                + "	},\n"
                + "	{\n"
                + "		\"teamName\" : \"Web\",\n"
                + "		\"members\" : [{\n"
                + "				\"id\" : \"015\",\n"
                + "				\"firstName\" : \"David\",\n"
                + "				\"lastName\" : \"Branton\",\n"
                + "				\"role\" : \"Web Team Lead\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\",\n"
                + "				\"teamLead\" : true\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"016\",\n"
                + "				\"firstName\" : \"James\",\n"
                + "				\"lastName\" : \"Ward\",\n"
                + "				\"role\" : \"Web Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"017\",\n"
                + "				\"firstName\" : \"Ryan\",\n"
                + "				\"lastName\" : \"French\",\n"
                + "				\"role\" : \"Web Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"018\",\n"
                + "				\"firstName\" : \"Adam\",\n"
                + "				\"lastName\" : \"Smith\",\n"
                + "				\"role\" : \"Web Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"019\",\n"
                + "				\"firstName\" : \"Leonard\",\n"
                + "				\"lastName\" : \"Da Costa\",\n"
                + "				\"role\" : \"Web Developer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			}\n"
                + "		]	\n"
                + "	},\n"
                + "	{\n"
                + "		\"teamName\" : \"Design\",\n"
                + "		\"members\" : [{\n"
                + "				\"id\" : \"020\",\n"
                + "				\"firstName\" : \"Hannah\",\n"
                + "				\"lastName\" : \"Tempest\",\n"
                + "				\"role\" : \"Design Team Lead\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\",\n"
                + "				\"teamLead\" : true\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"021\",\n"
                + "				\"firstName\" : \"Ellis\",\n"
                + "				\"lastName\" : \"Reed\",\n"
                + "				\"role\" : \"Designer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"022\",\n"
                + "				\"firstName\" : \"Pete\",\n"
                + "				\"lastName\" : \"Horsham\",\n"
                + "				\"role\" : \"Designer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"023\",\n"
                + "				\"firstName\" : \"Hemel\",\n"
                + "				\"lastName\" : \"Dave\",\n"
                + "				\"role\" : \"Designer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			},\n"
                + "			{\n"
                + "				\"id\" : \"024\",\n"
                + "				\"firstName\" : \"Hannah\",\n"
                + "				\"lastName\" : \"Corke\",\n"
                + "				\"role\" : \"Designer\",\n"
                + "				\"profileImageURL\" : \"http://mubaloo.com/dev/developerTestResources/profilePlaceholder.png\"\n"
                + "			}\n"
                + "		]	\n"
                + "	}\n"
                + "]";
        
        final StringBuffer results = new StringBuffer(res);
        String url = "http://mubaloo.com/dev/developerTestResources/team.json";
        HTTPProxyRequest request = new HTTPProxyRequest(url);

        String httpResponse = request.httpGET().getResponseText();

        assertNotNull(httpResponse);

        /*
        *<p>
        * 3rd party library JSONAssert has been user to compare to json strings
        *</p>
        */
        JSONAssert.assertEquals(results.toString(), httpResponse, true);    
    }
}
