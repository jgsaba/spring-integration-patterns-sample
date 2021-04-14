This pattern kind of simulates a synchronous communication, because the sender expects a return from
the receiver.

Notice in the gateway that the method annotated with `@Gateway` does return something. Besides, the
receiver's method that is activated when gets the message returns also returns something. 

In this case, Spring creates a temporary channel that handles with return messages, and it also creates
an error channel that is used when the receiver throws an exception. In this case the channel will conduct
the exception thrown to the sender.

More infos about this pattern can be found at https://www.enterpriseintegrationpatterns.com/patterns/messaging/RequestReply.html