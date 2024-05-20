package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.commonasteroid.Asteroid;
import dk.sdu.mmmi.cbse.commonasteroid.IAsteroidSplitter;

import java.util.Random;

public class AsteroidSplitter implements IAsteroidSplitter {

    private Random random = new Random();

    @Override
    public void createSplitAsteroid(Entity entity, GameData gameData, World world) {
        for(int i = 0;i < 2;i++) {
            Asteroid splittedAsteroid = new Asteroid();
            splittedAsteroid.setPolygonCoordinates(2, -2, 2, 2, -2, 2, -2, -2);
            splittedAsteroid.setX(entity.getX());
            splittedAsteroid.setY(entity.getY());
            splittedAsteroid.setRotation(random.nextInt(90));
            splittedAsteroid.setRadius(2);
            splittedAsteroid.setHitPoints(3);
            splittedAsteroid.setCanSplit(false);
            world.addEntity(splittedAsteroid);
        }
    }


}
