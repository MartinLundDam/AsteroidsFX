import dk.sdu.mmmi.asteroidsystem.AsteroidPlugin;
import dk.sdu.mmmi.asteroidsystem.AstoroidControlSystem;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Asteroid {
    exports dk.sdu.mmmi.asteroidsystem;
    requires Common;
    requires CommonAsteroid;
    provides IGamePluginService with AsteroidPlugin;
    provides IEntityProcessingService with AstoroidControlSystem;
}
