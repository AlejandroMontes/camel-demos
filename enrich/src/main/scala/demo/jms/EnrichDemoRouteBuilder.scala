package demo.jms

import org.apache.camel.processor.aggregate.AggregationStrategy
import org.apache.camel.scala.dsl.builder.ScalaRouteBuilder
import org.apache.camel.{CamelContext, Exchange}

/**
  * todo
  */
class EnrichDemoRouteBuilder(camelContext: CamelContext) extends ScalaRouteBuilder(camelContext) {

  "direct:a" ==> {
    log("received message")
    enrich("direct:b", new AggregationStrategy {
      override def aggregate(original: Exchange, resource: Exchange): Exchange = {
        original.out = original.in[String] + " " +  resource.in[String]
        original

      }
    })

  }

  "direct:b" ==> {
    transform(simple("world"))
  }


}
