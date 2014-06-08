package li.cil.oc.common.event

import li.cil.oc.api.event.RobotPlaceInAirEvent
import li.cil.oc.api
import cpw.mods.fml.common.eventhandler.SubscribeEvent

object AngelUpgradeHandler {
  @SubscribeEvent
  def onPlaceInAir(e: RobotPlaceInAirEvent) {
    val startComponents = 1 + e.robot.containerCount + e.robot.inventorySize
    e.setAllowed(((1 to e.robot.containerCount) ++ (startComponents until startComponents + e.robot.componentCount)).
      exists(slot => api.Items.get(e.robot.getStackInSlot(slot)) == api.Items.get("angelUpgrade")))
  }
}