package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Random;

public class CollisionSystem implements IPostEntityProcessingService {

    Random random = new Random();

    public CollisionSystem() {
    }

    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                }
                if (entity1.getClass() == entity2.getClass()) {
                    continue;
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    entity1.setHitPoints(entity1.getHitPoints() - 1);
                    entity2.setHitPoints(entity2.getHitPoints() - 1);

                    if (entity1.getHitPoints() < 1){
                        world.removeEntity(entity1);
                        }

                    if (entity2.getHitPoints() < 1) {
                        world.removeEntity(entity2);
                    }
                }
            }
        }
    }


    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < (entity1.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;
    }


}

