
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.playersystem.HelloWorld;
import org.splitPackageLayer.SplitPackageProvider.JavaSplitPackageProvider;

module Player {
    requires Common;
    requires CommonBullet;
    requires Splitpackage;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with dk.sdu.mmmi.cbse.playersystem.PlayerPlugin;
    provides IEntityProcessingService with dk.sdu.mmmi.cbse.playersystem.PlayerControlSystem;
    provides JavaSplitPackageProvider with HelloWorld;
}
