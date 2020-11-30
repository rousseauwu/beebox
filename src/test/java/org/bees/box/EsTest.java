package org.bees.box;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bees.box.entity.Student;
import org.bees.box.util.BeeEsClient;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*/*.xml")
@SpringBootTest
public class EsTest {

    private static Logger log = LoggerFactory.getLogger(EsTest.class);

    public static TransportClient client;

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void createClient() {
        try {
            Settings settings = Settings.builder()
                    .put("cluster.name", "elasticsearch").build();
            client = new PreBuiltTransportClient(settings);
            client.addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"),9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEsConnection() {
        try {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
                    .field("user", "kimchy")
                    .field("postDate", new Date())
                    .field("message", "trying out Elasticsearch")
                    .endObject();

            byte[] bytes = objectMapper.writeValueAsBytes(new Student("John", "female"));
            IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                    .setSource(builder).get();
            log.info(JSONObject.toJSONString(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
