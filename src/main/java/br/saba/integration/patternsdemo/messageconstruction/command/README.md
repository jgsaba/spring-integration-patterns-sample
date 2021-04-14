These classes implement the Command pattern integration which is a way to an application 
invokes a method of another application. 
In this case, the method invoked ideally should be a void method.

The Command Message pattern is one of the patterns documented within Enterprise Integration Pattern book. More info about this pattern can be found at https://www.enterpriseintegrationpatterns.com/patterns/messaging/CommandMessage.html

The class `CommandMessagePatternConfig` is annotated with `@EnableIntegration` to enable all Spring Integration features. By annotating a class with that,
Spring will automagically configure all the beans and underlying infrastructure to us use the features.

Also, `CommandMessagePatternConfig` configs a bean that implements `MessageChannel` interface. `MessageChannel` is the interface that defines a channel (pipe)
which a message goes through to reach a receiver. In this case, the implementation is `DirectChannel`, that is a simple P2P channel.

The `SwagGateway` interface is the point that connects a class that wants to send a message to a channel. `@MessagingGateway` annotation indicate that it is
a gateway. The attribute `defaultRequestChannel` defines to which channel the gateway publish the messages. In this case we want to send it to the channel
we created at `CommandMessagePatternConfig` named `swagChannel`.

The method `sendSwag` is annotated with `@Gateway` which indicates that when it is invoked it will redirect a message to the `defaultRequestChannel`

`RegistrationService` has a `SwagGateway` and uses it to send a message to the channel. It uses a message builder to include the payload and a custom header.
Note that the commit method invokes sendSwag from `SwagGateway` that is exactly the message that acts as a gateway to the channel.

Finally, there is `SwagService` annotated with `MessageEndpoint` that indicates this is an endpoint for a message that reaches a channel

Its method is annotated wih `@ServiceActivator` that indicates that it should be invoked when a message reaches a channel. The channel is
defined by the property `inputChannel`.
