This pattern, different from the others, do not meant to send a message to just one receiver. Instead it
publishes a message, and the channel broadcasts it to many receivers subscribed to that channel.

Notice that the main difference is at the Channel implementation used. Instead of using a `DirectChannel`, here
is used `PublishSubscribeChannel`, that is channel which supports multiple listeners.

Note: In all other cases that direct channel implementation is used the messages sent is alternate between
the receivers, but only one will receiver the message at a time.

More infos about this patterns can be found at https://www.enterpriseintegrationpatterns.com/patterns/messaging/EventMessage.html