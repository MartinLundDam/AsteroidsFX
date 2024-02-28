package dk.sdu.mmmi.cbse;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class EnemyControlSystem implements IEntityProcessingService {

    Random random = new Random();
    int randomDirection = random.nextInt(2);
    int randomShoot = random.nextInt(40); //shoot at random when = 39



    public void process(GameData gameData, World world) {

        for (Entity enemy : world.getEntities(Enemy.class)) {
            //enemy.setRotation(enemy.getRotation() + random.nextInt((11)-5));

            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + changeX*0.8); //make enemy a bit slower than playership
            enemy.setY(enemy.getY() + changeY*0.8);

            if (randomDirection == 0) {
                enemy.setRotation(enemy.getRotation() - 5);
            }
            if (randomDirection == 1) {
                enemy.setRotation(enemy.getRotation() + 5);
            }

            if(randomShoot == 39) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
                );
            }


        if (enemy.getX() < 0) {
            enemy.setX(1);
        }

        if (enemy.getX() > gameData.getDisplayWidth()) {
            enemy.setX(gameData.getDisplayWidth()-1);
        }

        if (enemy.getY() < 0) {
            enemy.setY(1);
        }

        if (enemy.getY() > gameData.getDisplayHeight()) {
            enemy.setY(gameData.getDisplayHeight()-1);
        }


        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
