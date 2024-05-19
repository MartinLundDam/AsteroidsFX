package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollisionSystemTest {
    @org.junit.jupiter.api.Test
    void collides() {

        Entity bullet = new Entity();
        Entity asterroid = new Entity();
        bullet.setX(200);
        bullet.setY(200);
        bullet.setRadius(1);
        asterroid.setX(219);
        asterroid.setY(200);
        asterroid.setRadius(19);

        CollisionSystem collisionSystem = new CollisionSystem();
        //There is collision
        assertTrue(collisionSystem.collides(bullet,asterroid));
    }

    @org.junit.jupiter.api.Test
    void notCollides(){
       Entity bullet = new Entity(); //2 entities
       Entity asterroid = new Entity();
       bullet.setX(200); //bullet x,y coordinates
       bullet.setY(200);
       bullet.setRadius(1);
       asterroid.setX(219); //astorid x,y coordinates
       asterroid.setY(200);
       asterroid.setRadius(16);

       CollisionSystem collisionSystem = new CollisionSystem();
        //There is not collision
       assertFalse(collisionSystem.collides(bullet,asterroid));
   }
}