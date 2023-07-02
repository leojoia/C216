package br.inatel.labs.labmqtt.client;

import java.util.UUID;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class SensorTemperaturaSubscriber {
	
	public static void main(String[] args) throws MqttException {
		
		String subscriberId = UUID.randomUUID().toString();
		MqttClient subscriber = new MqttClient(MyConstant.URI_BROKER, subscriberId);
		
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		subscriber.connect(options);
		
		subscriber.subscribe(MyConstant.TOPIC_1, (topic, msg) -> {
			byte[] payload = msg.getPayload();
			System.out.println("Payload recebido: "+ new String(payload));
			System.out.println("Topic recebido: "+ topic);
		});
		
	}

}
