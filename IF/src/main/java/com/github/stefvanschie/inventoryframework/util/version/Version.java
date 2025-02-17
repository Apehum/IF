package com.github.stefvanschie.inventoryframework.util.version;

import com.github.stefvanschie.inventoryframework.exception.UnsupportedVersionException;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.EnumSet;

/**
 * The different supported NMS versions
 *
 * @since 0.8.0
 */
public enum Version {

    /**
     * Version 1.14
     *
     * @since 0.10.0
     */
    V1_14,

    /**
     * Version 1.15
     *
     * @since 0.10.0
     */
    V1_15,

    /**
     * Version 1.16.1
     *
     * @since 0.10.0
     */
    V1_16_1,

    /**
     * Version 1.16.2 - 1.16.3
     *
     * @since 0.10.0
     */
    V1_16_2_3,

    /**
     * Version 1.16.4 - 1.16.5
     *
     * @since 0.10.0
     */
    V1_16_4_5,

    /**
     * Version 1.17
     *
     * @since 0.10.0
     */
    V1_17_0,

    /**
     * Version 1.17.1
     *
     * @since 0.10.0
     */
    V1_17_1,

    /**
     * Version 1.18.0
     *
     * @since 0.10.4
     */
    V1_18_0,

    /**
     * Version 1.18.1
     *
     * @since 0.10.4
     */
    V1_18_1,

    /**
     * Version 1.18.2
     *
     * @since 0.10.5
     */
    V1_18_2,

    /**
     * Version 1.19.0
     *
     * @since 0.10.6
     */
    V1_19_0,

    /**
     * Version 1.19.1
     *
     * @since 0.10.7
     */
    V1_19_1,

    /**
     * Version 1.19.2
     *
     * @since 0.10.7
     */
    V1_19_2,

    /**
     * Version 1.19.3
     *
     * @since 0.10.8
     */
    V1_19_3,

    /**
     * Version 1.19.4
     *
     * @since 0.10.9
     */
    V1_19_4,

    /**
     * Version 1.20
     *
     * @since 0.10.10
     */
    V1_20;

    /**
     * A collection of versions on which modern smithing tables are available.
     */
    private static final Collection<Version> MODERN_SMITHING_TABLE_VERSIONS = EnumSet.of(V1_19_4, V1_20);

    /**
     * Checks whether modern smithing tables exist on this version. Returns true if they do, otherwise false.
     *
     * @return true if modern smithing tables are available
     * @since 0.10.10
     */
    boolean existsModernSmithingTable() {
        return MODERN_SMITHING_TABLE_VERSIONS.contains(this);
    }

    /**
     * Checks whether legacy smithing tables exist on this version. Returns true if they do, otherwise false.
     *
     * @return true if legacy smithing tables are available
     * @since 0.10.10
     */
    @Contract(pure = true)
    boolean existsLegacySmithingTable() {
        return this != V1_20;
    }

    /**
     * Gets the version currently being used. If the used version is not supported, an
     * {@link UnsupportedVersionException} will be thrown.
     *
     * @return the version of the current instance
     * @since 0.8.0
     */
    @NotNull
    @Contract(pure = true)
    public static Version getVersion() {
        String version = Bukkit.getBukkitVersion().split("-")[0];

        switch (version) {
            case "1.14":
            case "1.14.1":
            case "1.14.2":
            case "1.14.3":
            case "1.14.4":
                return V1_14;
            case "1.15":
            case "1.15.1":
            case "1.15.2":
                return V1_15;
            case "1.16.1":
                return V1_16_1;
            case "1.16.2":
            case "1.16.3":
                return V1_16_2_3;
            case "1.16.4":
            case "1.16.5":
                return V1_16_4_5;
            case "1.17":
                return V1_17_0;
            case "1.17.1":
                return V1_17_1;
            case "1.18":
                return V1_18_0;
            case "1.18.1":
                return V1_18_1;
            case "1.18.2":
                return V1_18_2;
            case "1.19":
                return V1_19_0;
            case "1.19.1":
                return V1_19_1;
            case "1.19.2":
                return V1_19_2;
            case "1.19.3":
                return V1_19_3;
            case "1.19.4":
                return V1_19_4;
            case "1.20":
                return V1_20;
            default:
                throw new UnsupportedVersionException("The server version provided is not supported");
        }
    }
}
