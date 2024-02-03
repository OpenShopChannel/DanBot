package org.oscwii.danbot.commands;

import xyz.artuto.commando.api.annotation.CommandMethod;
import xyz.artuto.commando.api.annotation.Description;
import xyz.artuto.commando.api.command.CommandEvent;

public class PingCmd
{
    @CommandMethod("ping")
    @Description("Pong!")
    public void run(CommandEvent event)
    {
        event.getJDA().getRestPing().queue(ping ->
                event.replyFormatted("Pong! REST Ping: %dms | Gateway Ping: %dms",
                        ping, event.getJDA().getGatewayPing()));
    }
}
