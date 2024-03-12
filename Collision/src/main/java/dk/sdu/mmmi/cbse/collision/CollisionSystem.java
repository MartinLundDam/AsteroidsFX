package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.Objects;

public class CollisionSystem implements IPostEntityProcessingService {


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
        double xLen = entity1.getX() - entity2.getX();
        double yLen = entity1.getY() - entity2.getY();
        double Lengt = Math.sqrt(xLen * xLen + yLen * yLen);
        /*if (Lengt < (entity1.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;

         */
        return Lengt < (entity1.getRadius() + entity2.getRadius());
    }

}

