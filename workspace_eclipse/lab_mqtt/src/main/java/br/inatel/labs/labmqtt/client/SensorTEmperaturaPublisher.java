package br.inatel.labs.labmqtt.client;

import java.util.Random;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SensorTEmperaturaPublisher {
	
	public static void main(String[] args) throws MqttException {
		
		String publisherId = UUID.randomUUID().toString();
		MqttClient publisher = new MqttClient( MyConstant.URI_BROKER, publisherId);
		
		MqttMessage msg = getTemperaturaMessage();
		msg.setQos(0);
		msg.setRetained(true);
		
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		publisher.connect( options );
		
		publisher.publish(MyConstant.TOPIC_1, msg);
		
		publisher.disconnect();
		
	}

	private static MqttMessage getTemperaturaMessage() {
		Random r = new Random();
		double temperatura = 80 + r.nextDouble() * 20;
		byte[] payload = String.format("T:%04.2f", temperatura).getBytes();
		return new MqttMessage(payload);
	}
}
