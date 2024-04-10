import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;


module Collision {
    requires Common;
    requires Asteroid;
    provides IPostEntityProcessingService with dk.sdu.mmmi.cbse.collision.CollisionSystem;
}