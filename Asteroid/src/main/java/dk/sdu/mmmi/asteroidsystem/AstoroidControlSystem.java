package dk.sdu.mmmi.asteroidsystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.commonasteroid.Asteroid;

import java.util.Random;


public class AstoroidControlSystem implements IEntityProcessingService {

    private Random random = new Random();
    private int randomSpawn = random.nextInt(70);
    private Entity asteroid;

    private AsteroidSplitter asteroidSplitter = new AsteroidSplitter();

    public void process(GameData gameData, World world) {

        if (randomSpawn == 1) {
            //world.addEntity(Asteroid);
            asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);

            if (asteroid.isCanSplit()){
                if (asteroid.getHitPoints() < 2) {
                    asteroidSplitter.createSplitAsteroid(asteroid,gameData,world);
                    world.removeEntity(asteroid);
                }
            }

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

    }


    private Entity createAsteroid(GameData gameData) {
        //make astoroid spawn another way
        Entity enemyAsteroid = new Asteroid();
        enemyAsteroid.setPolygonCoordinates(-20, 0, -18, 10, -16, 8, -12, 12, -10, 10, -6, 10, -2, 12, 0, 10, -2, 6, 0, 4, -4, 0, 0, -3, -2, -6, -8, -8, -10, -12, -8, -16, -8, -16, -4);
        enemyAsteroid.setX(gameData.getDisplayHeight() / 4);
        enemyAsteroid.setY(gameData.getDisplayWidth() / 4);
        enemyAsteroid.setRotation(random.nextInt(90));
        enemyAsteroid.setRadius(10);
        enemyAsteroid.setHitPoints(5);
        return enemyAsteroid;
    }

}


