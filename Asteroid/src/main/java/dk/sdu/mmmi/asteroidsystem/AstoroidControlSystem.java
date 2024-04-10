package dk.sdu.mmmi.asteroidsystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;



public class AstoroidControlSystem implements IEntityProcessingService {

    Random random = new Random();
    int randomDirection = random.nextInt(2);
    int randomSpawn = random.nextInt(70);

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
        //enemyAsteroid.setPolygonCoordinates(-7,5,-6.5,9,-3, 10, -1, 9, -2, 8, 1, 7, 0, 6, 1, 5, -1, 3, -2, 4, -3, 2, -5, 3, -7, 3);
        enemyAsteroid.setPolygonCoordinates(-20, 0, -18, 10, -16, 8, -12, 12, -10, 10, -6, 10, -2, 12, 0, 10, -2, 6, 0, 4, -4, 0, 0, -3, -2, -6, -8, -8, -10, -12, -8, -16, -8, -16, -4);
        enemyAsteroid.setX(gameData.getDisplayHeight()/4);
        enemyAsteroid.setY(gameData.getDisplayWidth()/4);
        enemyAsteroid.setRotation(random.nextInt(90));
        enemyAsteroid.setRadius(10);

        return enemyAsteroid;
    }
}


