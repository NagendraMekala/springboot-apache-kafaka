package com.example.springBootKafakaProducer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class AsyncProducerHandler implements ListenableFutureCallback<SendResult<String, User>>{

	@Override
	public void onSuccess(SendResult<String, User> result) {
		
		// ProducerRecord details:
		System.out.println("****************Producer Record Deatials****************");
		ProducerRecord<String, User> record = result.getProducerRecord();
		System.out.println("topic: "+ record.topic());
		System.out.println("partion: "+ record.partition());
		System.out.println("TimeStamp: "+ record.timestamp());
		System.out.println("Key: "+ record.key());
		System.out.println("Value: "+ record.value());
		
		System.out.println("****************RecordMetadata Deatials****************");
		//RecordMetadata deails:
		RecordMetadata metaData = result.getRecordMetadata();
		System.out.println("metaData partion: "+ metaData.partition());
		System.out.println("metaData topic: "+ metaData.topic());
		System.out.println("metaData timestamp: "+ metaData.timestamp());
		System.out.println("metaData offset: "+ metaData.offset());
		System.out.println("metaData checksum: "+ metaData.checksum());
		System.out.println("metaData toString: "+ metaData.toString());
		
	}

	@Override
	public void onFailure(Throwable ex) {
		System.out.println("Exception onFailue Method: "+ex);
	}
}
