module Core {
    requires Common;
    requires CommonBullet;    
    requires javafx.graphics;
    requires spring.core;
    requires spring.context;
    requires spring.beans;
    //requires spring.core; //requires spring
    exports dk.sdu.mmmi.cbse.main; //export main to make ModuleConfig see the interfaces
    opens dk.sdu.mmmi.cbse.main to javafx.graphics,spring.core;
    uses dk.sdu.mmmi.cbse.common.services.IGamePluginService;
    uses dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
    uses dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
}


