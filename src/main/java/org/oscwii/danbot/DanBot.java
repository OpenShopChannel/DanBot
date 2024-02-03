package org.oscwii.danbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.oscwii.danbot.commands.PingCmd;
import xyz.artuto.commando.api.CommandManager;
import xyz.artuto.commando.internal.CommandManagerImpl;
import xyz.artuto.commando.internal.annotation.argument.AnnotatedCommandConstructorImpl;

import static org.oscwii.danbot.App.getLogger;

public class DanBot extends ListenerAdapter
{
    private final CommandManager commandManager;
    private final JDA jda;

    public DanBot()
    {
        // TODO when API is ready, use it
        this.commandManager = new CommandManagerImpl();
        var ann = new AnnotatedCommandConstructorImpl(commandManager);
        ann.parse(new PingCmd());

        this.jda = JDABuilder.createDefault(System.getenv("TOKEN"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(this, commandManager)
                .build();
    }

    @Override
    public void onReady(ReadyEvent event)
    {
        getLogger().info("Logged in as {} ({})", event.getJDA().getSelfUser().getAsTag(),
                event.getJDA().getSelfUser().getId());
        getLogger().info("We are ready!");
    }
}
