package com.eb.warehouse;

import com.google.inject.*;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

import java.util.Set;

/**
 * Created by eb on 13.06.2015.
 */
public final class PcxStationImplModule extends PrivateModule {

    private static final String STATION_ID_BINDING_NAME = "stationId";
    private final String stationId;
    private final Set<String> targetStationIds;
    private final Key<PcxStation> stationKey;
    private final Multibinder<PcxStation> multibinder;
    private final Module targetStationSelectionModule;

    public PcxStationImplModule(Multibinder<PcxStation> multibinder, String stationId, Set<String> targetStationIds, Module targetStationSelectionModule) {
        this.stationId = stationId;
        this.targetStationIds = targetStationIds;
        this.multibinder = multibinder;
        this.targetStationSelectionModule = targetStationSelectionModule;
        stationKey = Key.get(PcxStation.class, Names.named(stationId));
    }

    private static void bindStationId(Binder binder, String stationId) {
        binder.bind(String.class).annotatedWith(Names.named(STATION_ID_BINDING_NAME)).toInstance(stationId);
    }

    private static void bindTargets(Binder binder, Set<String> targets) {
        binder.bind(new TypeLiteral<Set<String>>() {
        }).toInstance(targets);
    }

    private static void bindStation(Binder binder, String stationId, Set<String> targets,
                                    Key<PcxStation> stationKey) {
        bindStationId(binder, stationId);
        bindTargets(binder, targets);
        binder.bind(stationKey).to(PcxStationImpl.class);
    }

    @Override
    protected void configure() {
        bindStation(binder(), stationId, targetStationIds, stationKey);
        install(new AnyTargetSelectingWithTuCountThresholdPcxStationModule());
        expose(stationKey);
        multibinder.addBinding().to(stationKey);
    }
}
