package org.example.moomyeongso.common.config;

import org.springframework.data.convert.TypeInformationMapper;
import org.springframework.data.mapping.Alias;
import org.springframework.data.util.TypeInformation;

public class LegacyPackageTypeInformationMapper implements TypeInformationMapper {

    private static final String LEGACY_PREFIX = "org.example.namelesschamber.";
    private static final String CURRENT_PREFIX = "org.example.moomyeongso.";

    @Override
    public TypeInformation<?> resolveTypeFrom(Alias alias) {
        if (alias == null) {
            return null;
        }
        Object value = alias.getValue();
        if (value == null) {
            return null;
        }
        String typeName = value.toString();
        if (typeName.startsWith(LEGACY_PREFIX)) {
            String migratedName = CURRENT_PREFIX + typeName.substring(LEGACY_PREFIX.length());
            try {
                Class<?> target = Class.forName(migratedName);
                return TypeInformation.of(target);
            } catch (ClassNotFoundException ignored) {
                return null;
            }
        }
        return null;
    }

    @Override
    public Alias createAliasFor(TypeInformation<?> type) {
        if (type == null) {
            return Alias.empty();
        }
        return Alias.of(type.getType().getName());
    }
}
