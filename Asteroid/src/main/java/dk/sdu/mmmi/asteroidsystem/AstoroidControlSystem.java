package dk.sdu.mmmi.asteroidsystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;



public class AstoroidControlSystem implements IEntityProcessingService {

    Random random = new Random();
    int randomDirection = random.nextInt(2);
    int randomSpawn = random.nextInt(50);

    private Entity asteroid;


    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX*0.5);
            asteroid.setY(asteroid.getY() + changeY*0.5);

            //below makes the astoroid stop when hit border.
            if (asteroid.getX() < 0) {
                world.removeEntity(asteroid);
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                world.removeEntity(asteroid);
            }

            if (asteroid.getY() < 0) {
                world.removeEntity(asteroid);
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                world.removeEntity(asteroid);
            }

        }
        if (randomSpawn == 1) {
            //world.addEntity(Asteroid);
            asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }
    private Entity createAsteroid(GameData gameData) {
        //make astoroid spawn another way
        Entity enemyAsteroid = new Asteroid();
        enemyAsteroid.setPolygonCoordinates(-5,-5,10,-10,5,5,-10,10);
        enemyAsteroid.setX(gameData.getDisplayHeight()/4);
        enemyAsteroid.setY(gameData.getDisplayWidth()/4);
        enemyAsteroid.setRadius(5);
        return enemyAsteroid;
    }
}


