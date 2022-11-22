package net.outercloud.upgradeables.Hoppers;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class AbstractHopperScreen extends HandledScreen<AbstractHopperScreenHandler> {
    private Identifier texture;

    public Identifier getTexture(){
        return new Identifier("upgradeables:textures/gui/container/wooden_hopper.png");
    }

    public AbstractHopperScreen(AbstractHopperScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        this.passEvents = false;
        this.backgroundHeight = 133;
        this.playerInventoryTitleY = this.backgroundHeight - 94;

        this.texture = getTexture();
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShaderTexture(0, texture);

        int i = (this.width - this.backgroundWidth) / 2;
        int j = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
    }
}
