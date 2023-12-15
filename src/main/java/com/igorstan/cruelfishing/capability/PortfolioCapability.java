package com.igorstan.cruelfishing.capability;

import com.igorstan.cruelfishing.stocks.Portfolio;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PortfolioCapability implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<Portfolio> PORTFOLIO = CapabilityManager.get(new CapabilityToken<Portfolio>() {});

    private Portfolio portfolio = null;
    private final LazyOptional<Portfolio> optional = LazyOptional.of(this::createPortfolio);

    private Portfolio createPortfolio() {
        if(this.portfolio == null) {
            this.portfolio = new Portfolio();
        }
        return this.portfolio;
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == PORTFOLIO) {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPortfolio().saveNBT(nbt);

        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {

        createPortfolio().loadNBT(nbt);
    }
}
