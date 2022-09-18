import org.apache.commons.lang3.SerializationUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import java.nio.charset.StandardCharsets;

public class Send {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            //String message = "Hello kk nadisa";
	        //User messageObject= new User(1l,"Anton","Pakujaya");
	        //byte[] dataObject = SerializationUtils.serialize(messageObject);
            //channel.basicPublish("", QUEUE_NAME, null, dataObject);
            //System.out.println(" [x] Sent '" + messageObject+"===>" +dataObject + "'");
            JSONObject obj = new JSONObject();
            obj.put("Transaction","Test value");
            channel.basicPublish("", QUEUE_NAME, null, obj.toString().getBytes());
            System.out.println(" [x] Sent '" + obj.toString() + "'");
        }
    }
}
