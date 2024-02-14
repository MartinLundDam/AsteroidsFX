package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


/**
 *
 *@Precondition: Game is running or not running yet
 *@Postcondition: Game is either stopped or started
 *
 * @author jcs
 * @throws
 *
 */
public interface IPostEntityProcessingService {

    void process(GameData gameData, World world);
}
