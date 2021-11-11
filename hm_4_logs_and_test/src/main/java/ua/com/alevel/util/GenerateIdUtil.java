package ua.com.alevel.util;

import ua.com.alevel.entity.BaseEntity;

import java.util.UUID;

public final class GenerateIdUtil {

    private GenerateIdUtil() {}

    public static String generateId(BaseEntity[] entities) {
        String id = UUID.randomUUID().toString();
        for (BaseEntity baseEntity : entities) {
            if (baseEntity != null && baseEntity.getId().equals(id)) {
                return generateId(entities);
            }
        }
        return id;
    }
}
