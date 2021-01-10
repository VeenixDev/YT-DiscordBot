package com.youtube.dcbot;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.util.Arrays;

public class Main {

    private static final String token = TOKEN.TOKEN;

    //Bot intents
    private static final GatewayIntent[] intents = new GatewayIntent[] {
            GatewayIntent.GUILD_PRESENCES,
            GatewayIntent.GUILD_MEMBERS,
            GatewayIntent.GUILD_MESSAGE_REACTIONS,
            GatewayIntent.GUILD_MESSAGE_TYPING,
            GatewayIntent.GUILD_MESSAGES,
            GatewayIntent.GUILD_VOICE_STATES,
            GatewayIntent.GUILD_EMOJIS,
            GatewayIntent.GUILD_BANS,
            GatewayIntent.DIRECT_MESSAGES,
            GatewayIntent.GUILD_EMOJIS,
            GatewayIntent.DIRECT_MESSAGE_REACTIONS,
            GatewayIntent.GUILD_INVITES,
            GatewayIntent.GUILD_WEBHOOKS
    };

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.setActivity(Activity.playing("Type .help"));
        //builder.addEventListeners();
        builder.enableIntents(Arrays.asList(intents));
        builder.setAutoReconnect(true);
        builder.setMemberCachePolicy(MemberCachePolicy.ALL);

        builder.build();
    }

}
