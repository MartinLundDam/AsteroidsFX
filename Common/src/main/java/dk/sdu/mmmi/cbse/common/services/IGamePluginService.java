package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     *
     *@Precondition: Game is running or not running yet
     *@Postcondition: Game is either stopped or started
     *
     * @param gameData
     * @param world
     * @throws IllegalStateException
     *
     */
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
