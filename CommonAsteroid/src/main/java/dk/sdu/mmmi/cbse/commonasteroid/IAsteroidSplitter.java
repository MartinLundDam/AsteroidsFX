package dk.sdu.mmmi.cbse.commonasteroid;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IAsteroidSplitter {
    public void createSplitAsteroid(Entity entity, GameData gameData, World world);
}