package com.workshop.bicycles;

import com.workshop.db.entity.Frame;
import com.workshop.db.specification.PartQueryBuilder;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class PartQueryTest {

    @Test
    void testQueryBuilder() throws Exception {
        String query = new PartQueryBuilder()
                .base("select * from frame")
                .where("material='carbon'")
                .and("brand='Kross")
                .build();


    }
}
