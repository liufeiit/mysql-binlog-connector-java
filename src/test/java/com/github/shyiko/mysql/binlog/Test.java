package com.github.shyiko.mysql.binlog;

import com.github.shyiko.mysql.binlog.BinaryLogClient.EventListener;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventType;
import com.github.shyiko.mysql.binlog.event.deserialization.ByteArrayEventDataDeserializer;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

/**
 * @author 刘飞 E-mail:liufei_it@126.com
 *
 * @version 1.0.0
 * @since 2015年7月16日 下午5:37:52
 */
public class Test {

	public static void main(String[] args) throws Throwable {
//		BinaryLogClient client = new BinaryLogClient("10.146.30.209", 3307, "dap", "meandpay123");
//		BinaryLogClient client = new BinaryLogClient("10.146.30.205", 3306, "root", "meandpay123");
		BinaryLogClient client = new BinaryLogClient("10.146.30.209", 3306, "root", "meandpay123");
		EventDeserializer eventDeserializer = new EventDeserializer();
		eventDeserializer.setEventDataDeserializer(EventType.EXT_DELETE_ROWS, new ByteArrayEventDataDeserializer());
		client.setEventDeserializer(eventDeserializer);
		client.registerEventListener(new EventListener() {
			@Override
			public void onEvent(Event event) {
				System.out.println(event);
			}
		});
		client.connect();
	}
}