/*
 *     Copyright (C) 2021 PugzAreCute
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.pugzarecute.randomdeathmessage.mixin;

import com.pugzarecute.randomdeathmessage.RandomDeathMessage;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.concurrent.ThreadLocalRandom;


@Mixin(DamageSource.class)
public class CombatTrackMixin {

    /**
     * @author PugzAreCute/PutoPug
     * @reason Randomize Death messages
     */
    @Overwrite
    public Component getLocalizedDeathMessage(LivingEntity entity) {


        String message = RandomDeathMessage.MESSAGES.get(ThreadLocalRandom.current().nextInt(0, RandomDeathMessage.MESSAGES.size())).replaceAll("<rdm[.]player[.]name>",entity.getDisplayName().getString());
        /*
        IMPL WORKS BUT DOES NOT RENDER PROPERLY ON DEATHSCREEN(MC ISSUE)

        List<String> list = new ArrayList<>(Arrays.stream(message.split("<rdm[.]format[.]newline>")).toList());
        List<TextComponent> textComponents= new ArrayList<>();
        for (String s:
             list) {

            textComponents.add(new TextComponent(s.replaceAll("<rdm[.]format[.]newline>","")));
        }

        return CommonComponents.joinLines(textComponents);*/
        return new TextComponent(message);
    }
}
