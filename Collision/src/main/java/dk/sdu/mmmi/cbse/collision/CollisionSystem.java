package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Objects;

public class CollisionSystem implements IPostEntityProcessingService {

/*
    public CollisionSystem() {
    }

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                if (Objects.equals(entity1.getID(), entity2.getID())) {
                    continue;
                }
                if (isColliding(entity1,entity2)) {
                    world.removeEntity(entity1); //remove bullet and the hitted entity.
                    world.removeEntity(entity2);

                    //make use of hitpoints, so a enemy has 5 hitpoint = 5 bullets.
                }


            }
        }
    }

    public boolean isColliding(Entity entity1, Entity entity2) {
        float xLen = (float) entity1.getX() - (float) entity2.getX();
        float yLen = (float) entity1.getY() - (float) entity2.getY();
        float Lengt = (float) Math.sqrt(xLen * xLen + yLen * yLen);
        /*if (Lengt < (entity1.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;


        return Lengt < (entity1.getRadius() + entity2.getRadius());
    }

 */
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
//                System.out.println("check 2 entities");

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    System.out.println("Collide!!!");
                    world.removeEntity(entity1);
                    world.removeEntity(entity2);
                }
            }
        }

    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < (entity1.getRadius() + entity2.getRadius())) {
            //System.out.println("collides");
            return true;
        }
        //System.out.println("collides method");
        return false;

        //return distance < (entity1.getRadius() + entity2.getRadius());
    }


}

