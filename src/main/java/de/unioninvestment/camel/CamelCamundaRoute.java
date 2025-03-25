//package de.unioninvestment.camel;
//
//import java.util.Set;
//
//import org.apache.camel.CamelContext;
//import org.apache.camel.builder.RouteBuilder;
//import org.springframework.boot.availability.AvailabilityChangeEvent;
//import org.springframework.boot.availability.ReadinessState;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.apache.camel.model.rest.RestBindingMode;
//
//@Component
//public class CamelCamundaRoute extends RouteBuilder{
//	
//	
//	@EventListener
//	public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
//		switch (event.getState()) {
//			case ACCEPTING_TRAFFIC -> {
//				System.out.println("Camel Route builder is ready to accepts messages");
//			}
//			case REFUSING_TRAFFIC -> {
//				System.out.println("Camel Route builder is not ready to accepts messages");
//			}
//		}
//	}
//	
//	@Override
//	public void configure() throws Exception {
//		
//		restConfiguration()
//			.component("undertow")
//			.bindingMode(RestBindingMode.off)	        
//			.contextPath("/")
//			.host("0.0.0.0")
//			.port(8085);
//		
//		rest("/")
//    		.get("test")	    	
//    		.to("direct:manageTestRest");
//		
//	    from("direct:manageTestRest")
//    		.routeId("manage-test-rest-requests")
//    		.log("Test rest recieved correctly");
//
//	    
////		from("timer://camundaStarter?fixedRate=true&period=60000")
////			.id("camel-camunda-starter")
////			.to("log:start_camunda_bpmn_from_camel_route")
////			.setBody(constant("test"))
////			.to("camunda-bpm://start?processDefinitionKey=camunda-camel");
//		
//		from("direct:2camel")
//			.routeId("2camel") 
//			.id("2camel")
//			.to("log:camunda_bpmn_called_camel_route");
//
//		
//	}
//
//	@Override
//	public void addTemplatedRoutesToCamelContext(CamelContext context) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Set<String> updateRoutesToCamelContext(CamelContext context) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
