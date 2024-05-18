package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     *@Precondition: Gamedata must be loaded before the world open.
     *@Postcondition: All processes must be terminated.
     *
     * @param gameData
     * @param world
     */
    void process(GameData gameData, World world);
}
