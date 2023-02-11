package com.pugzarecute.randomdeathmessage;

import net.minecraftforge.fml.common.Mod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Mod("randomdeathmessage")
public class RngDeathMsg
{
    public static final URL REMOTE_URL;

    static {
        try {
            REMOTE_URL = new URL("https://raw.githubusercontent.com/PugsMods/RandomDeathMessage/1.18.2/src/main/resources/messages.txt");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static final List<String> MESSAGES = initRDM();

    public RngDeathMsg() {
    }
    public static List<String> initRDM() {

        //The compiled jar will have a hardcoded json which can only be updated by updating the mod.
        //Possible config to change url and to force hardcoded json.

        //you gigabrain use a text file
        try {
            List<String> returnList = new ArrayList<>();
            Scanner s = new Scanner(REMOTE_URL.openStream());
            while (s.hasNextLine()) returnList.add(s.nextLine());
            return returnList;
        } catch (IOException e) {
            System.out.println("Remote messages failure. Use fallback.");

            try {
                return Files.readAllLines(Path.of(RngDeathMsg.class.getResource("/messages.txt").getPath()));
            } catch (IOException ex) {
                System.out.println("RDM Total Failiure.");
                throw new RuntimeException(ex);
            }
        }
    }
}
