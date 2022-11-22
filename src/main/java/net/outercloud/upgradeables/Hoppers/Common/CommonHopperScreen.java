package net.outercloud.upgradeables.Hoppers.Common;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.outercloud.upgradeables.Hoppers.Common.CommonHopperScreenHandler;
import net.outercloud.upgradeables.Upgradeables;
import net.outercloud.upgradeables.UpgradeablesClient;

@Environment(EnvType.CLIENT)
public class CommonHopperScreen extends HandledScreen<CommonHopperScreenHandler> {
    private static final Identifier WOODEN_TEXTURE = new Identifier("upgradeables:textures/gui/container/wooden_hopper.png");
    private static final Identifier STONE_TEXTURE = new Identifier("upgradeables:textures/gui/container/stone_hopper.png");

    public CommonHopperScreen(CommonHopperScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        this.passEvents = false;
        this.backgroundHeight = 133;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        switch (handler.hopperType){
            case STONE -> {
                RenderSystem.setShaderTexture(0, STONE_TEXTURE);
            }
            default -> {
                RenderSystem.setShaderTexture(0, WOODEN_TEXTURE);
            }
        }

        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}
