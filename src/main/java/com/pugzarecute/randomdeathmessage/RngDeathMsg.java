package com.pugzarecute.randomdeathmessage;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.Map;

@Mod("randomdeathmessage")
public class RngDeathMsg
{
    public RngDeathMsg() {
    }
    public static final String[] allowedDeaths = initRDM();

    public static String[] initRDM() {

        //The compiled jar will have a hardcoded json which can only be updated by updating the mod.
        //Possible config to change url and to force hardcoded json.


        final JsonObject messages;
        try {
            messages = new Gson().toJsonTree(new InputStreamReader(new java.net.URL("gethub.com/rdm/blehbleh").openStream())).getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException("Remote JSON Request Failiure. Switch to hardcoded json");
        }
        String[] messagesArray = new String[messages.size()+1];
        int i=0;
        for(Map.Entry<String, JsonElement> entry : messages.entrySet()) {
            messagesArray[i] = entry.getValue().getAsString();
            i++;
        }
        return messagesArray;
    }
}
