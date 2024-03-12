package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }


    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }


    private Entity createAsteroid(GameData gameData) {
        // TODO: make astoroid spawn in another way
        Entity enemyAsteroid = new Asteroid();
        enemyAsteroid.setPolygonCoordinates(-5,-5,10,-10,5,5,-10,10);
        enemyAsteroid.setX(gameData.getDisplayHeight()/4);
        enemyAsteroid.setY(gameData.getDisplayWidth()/4);
        enemyAsteroid.setRadius(5);
        enemyAsteroid.setHitPoints(2); //need 2 hit to die.

        //rotation

        return enemyAsteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }

}
