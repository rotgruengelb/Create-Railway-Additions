package net.rotgruengelb.create_railway_additions.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class SpeakerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {

    private String text = "";
    private int range = 10;

    public SpeakerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPEAKER, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("text.create_railway_additions.speaker.display_name");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return null;
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putString("speaker.text", text);
        nbt.putInt("speaker.range", range);
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        text = nbt.getString("speaker.text");
        range = nbt.getInt("speaker.range");
    }
    public static void tick(World world, BlockPos blockPos, BlockState state, SpeakerBlockEntity entity, MinecraftServer server) {
        if(world.isClient()) {
            return;
        }

        if(hasText(entity) && world.isReceivingRedstonePower(blockPos)) {
            narrateText(entity, server);
        }
    }

    private static void narrateText(SpeakerBlockEntity entity, MinecraftServer server) {
        server.getPlayerManager().broadcast(Text.of("Test"), false);
    }

    private static boolean hasText(SpeakerBlockEntity entity) {
        return (!Objects.equals(entity.text, ""));
    }
}
