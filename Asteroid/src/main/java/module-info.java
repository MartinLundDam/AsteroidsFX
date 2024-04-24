import dk.sdu.mmmi.cbse.playersystem.AsteroidPlugin;
import dk.sdu.mmmi.cbse.playersystem.AstoroidControlSystem;
import dk.sdu.mmmi.cbse.playersystem.HelloWorld;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.splitPackageLayer.SplitPackageProvider.JavaSplitPackageProvider;

module Asteroid {
    requires Common;
    requires Splitpackage;
    provides IGamePluginService with AsteroidPlugin;
    provides IEntityProcessingService with AstoroidControlSystem;
    provides JavaSplitPackageProvider with HelloWorld;
}
