package ml.dhs.kafkatest
import scala.collection.JavaConverters._
import org.apache.kafka.clients.consumer.{KafkaConsumer, ConsumerConfig}

import org.apache.kafka.common.serialization.StringDeserializer 
import java.util.Properties
import java.util.Collections
object KafkaTest {
  def main(args: Array[String]): Unit = {
    val props = new Properties()
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:29092")
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-1")
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])

    val kafkaConsumer = new KafkaConsumer[String, String](props)

    // Subscribe to the topic.
    kafkaConsumer.subscribe(Collections.singletonList("test.test"))

    while (true) {
      val results = kafkaConsumer.poll(2000).asScala
      for (result <- results) {
          println(s"Key: ${result.key()}, Value: ${result.value()}, timestamp: ${result.timestamp}")
        // Do stuff
      }
    }
  }
}



